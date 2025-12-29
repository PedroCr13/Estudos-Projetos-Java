package com.hachathon.backend_simulador_api.excepitons;

public class PrazoNaoDiponivelException extends RuntimeException{
	
	public PrazoNaoDiponivelException(String message) {
		super(message);
	}
}
