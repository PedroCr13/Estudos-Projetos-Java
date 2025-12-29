package com.hachathon.backend_simulador_api.excepitons;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hachathon.backend_simulador_api.DTO.ErroDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class SimulacaoExceptionHandler {
	
	@Autowired
	private HttpServletRequest request;
	
    @ExceptionHandler({ProdutoIndisponivelException.class, CamposVazioException.class, PrazoNaoDiponivelException.class})
    public ResponseEntity<ErroDTO> handleSimulacaoExceptions(RuntimeException ex) {
        String mensagem = switch (ex.getClass().getSimpleName()) {
            case "ProdutoIndisponivelException" -> "Não há produtos disponíveis para o valor solicitado.";
            case "CamposVazioException" -> "Campos vazios na solicitação.";
            case "PrazoNaoDiponivelException" -> "Prazo não permitido para o valor solicitado.";
            default -> "Erro inesperado.";
        };

        ErroDTO erro = new ErroDTO(422, ex.getMessage(), request.getRequestURI(), LocalDateTime.now());
        return ResponseEntity.unprocessableEntity().body(erro);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> handleValidacao(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult()
                            .getFieldErrors()
                            .stream()
                            .map(error -> error.getDefaultMessage())
                            .findFirst()
                            .orElse("Erro de validação");

        ErroDTO erro = new ErroDTO(400, mensagem, request.getRequestURI(), LocalDateTime.now());
        return ResponseEntity.badRequest().body(erro);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroDTO> handleJsonInvalido(HttpMessageNotReadableException ex) {
        ErroDTO erro = new ErroDTO();
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setMessage("Erro ao processar o JSON enviado. JSON esperado: valorSolicitado e prazo.");
        erro.setPath(request.getRequestURI());
        erro.setTimestamp(LocalDateTime.now());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    
}
