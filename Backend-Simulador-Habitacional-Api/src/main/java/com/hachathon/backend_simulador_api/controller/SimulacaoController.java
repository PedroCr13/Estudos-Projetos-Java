package com.hachathon.backend_simulador_api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hachathon.backend_simulador_api.DTO.RelatorioSimualacaoAgrupadoDataResponseDTO;
import com.hachathon.backend_simulador_api.DTO.RelatorioSimulacaoPaginadoDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoRelatorioAgrupadoDataDTO;
import com.hachathon.backend_simulador_api.DTO.SimulacaoRequest;
import com.hachathon.backend_simulador_api.DTO.SimulacaoResponseDTO;
import com.hachathon.backend_simulador_api.service.SimulacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SimulacaoController {

    @Autowired
    private SimulacaoService simulacaoService;

    @PostMapping("/simular")
    public ResponseEntity<SimulacaoResponseDTO> criarSimulacao(@Valid @RequestBody SimulacaoRequest request) {
    	SimulacaoResponseDTO simulacao = simulacaoService.criarSimulacao(request);
        return ResponseEntity.ok(simulacao);
    }
    
    @GetMapping("/listar_todas_simulacoes")
    public ResponseEntity<RelatorioSimulacaoPaginadoDTO> listarSimulacoes(
    		@RequestParam(defaultValue = "0") int pagina, 
    		@RequestParam(defaultValue = "200") int qtdRegistrosPagina){
    	
    	RelatorioSimulacaoPaginadoDTO relatorio = simulacaoService.gerarRelatorioSimulacoes(pagina, qtdRegistrosPagina);
    	return ResponseEntity.ok(relatorio);
    } 
    
 
    @GetMapping("/simulacoes_data")
    public ResponseEntity<List<RelatorioSimualacaoAgrupadoDataResponseDTO>> listarSimulacoesAgrupadasData() {
    	List<SimulacaoRelatorioAgrupadoDataDTO> simulacoes = simulacaoService.gerarRelatorioSimulacaoAgrupadoData();
    	List<RelatorioSimualacaoAgrupadoDataResponseDTO> simulacoesPorData = simulacaoService.gerarRelatorioSimulacoesAgrupadoChaveData(simulacoes);
    	
    	return ResponseEntity.ok(simulacoesPorData);
    }
	
}

