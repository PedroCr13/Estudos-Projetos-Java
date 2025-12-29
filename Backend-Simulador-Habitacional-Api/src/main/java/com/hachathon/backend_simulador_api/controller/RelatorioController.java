package com.hachathon.backend_simulador_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachathon.backend_simulador_api.monitoring.TempoInterceptor;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	
    @Autowired
    private TempoInterceptor tempoInterceptor;

    @GetMapping
    public Map<String, Map<String, Object>> relatorio() {
        Map<String, Map<String, Object>> resultado = new HashMap<>();

        tempoInterceptor.getTempos().forEach((endpoint, tempos) -> {
            long max = tempos.stream().mapToLong(Long::longValue).max().orElse(0);
            long min = tempos.stream().mapToLong(Long::longValue).min().orElse(0);
            long avg = tempos.stream().mapToLong(Long::longValue).sum() / tempos.size();

            Map<String, Object> stats = new HashMap<>();
            stats.put("quantidade", tempos.size());
            stats.put("tempoMaximoMs", max / 1_000_000);
            stats.put("tempoMinimoMs", min / 1_000_000);
            stats.put("tempoMedioMs", avg / 1_000_000);

            resultado.put(endpoint, stats);
        });

        return resultado;
    }

}
