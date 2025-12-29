package com.hachathon.backend_simulador_api.monitoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TempoInterceptor implements HandlerInterceptor {
	              //map coleção com chave e valor, tipo Dicionary do c#
    private final Map<String, List<Long>> temposPorEndpoint = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.nanoTime());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (long) request.getAttribute("startTime");
        long duration = System.nanoTime() - startTime;

        String path = request.getRequestURI();
        temposPorEndpoint.computeIfAbsent(path, k -> new ArrayList<>()).add(duration);
    }

    public Map<String, List<Long>> getTempos() {
        return temposPorEndpoint;
    }
}
