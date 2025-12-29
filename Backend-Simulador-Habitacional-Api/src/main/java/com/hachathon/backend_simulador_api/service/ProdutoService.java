package com.hachathon.backend_simulador_api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hachathon.backend_simulador_api.entity.sqlserver.Produto;
import com.hachathon.backend_simulador_api.sqlserver.repository.ProdutoRepository;

@Service				
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	public List<Produto> buscarProdutosPeloValorSolicitado(BigDecimal valor) {
		return produtoRepository.encontraProdutoAdequadoPorValor(valor);
	}	
	
}
