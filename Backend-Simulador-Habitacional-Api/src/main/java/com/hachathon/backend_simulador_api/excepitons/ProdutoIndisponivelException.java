package com.hachathon.backend_simulador_api.excepitons;

public class ProdutoIndisponivelException extends RuntimeException {
	
	public ProdutoIndisponivelException(String message) {
		super(message);
	}
}
