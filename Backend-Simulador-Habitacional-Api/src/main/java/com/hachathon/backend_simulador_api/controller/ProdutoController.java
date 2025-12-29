package com.hachathon.backend_simulador_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachathon.backend_simulador_api.entity.sqlserver.Produto;
import com.hachathon.backend_simulador_api.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/listar_produtos")
	public List<Produto> listarProdutos() {
		return produtoService.listarTodosProdutos();
	}
}
