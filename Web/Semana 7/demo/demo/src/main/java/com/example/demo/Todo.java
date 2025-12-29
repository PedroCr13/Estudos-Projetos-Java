package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

// Está será a entidade persistente
// Representa uma tarefa no gerenciador de tarefas
// Criado usando Record que é um objeto imutável para transferência de dados entre objetos
// Uma vez atribuídos os valores eles não podem ser alterados.
// Define os atributos já na declaração (diferente de uma classe)

@Document
public record Todo(String id, String titulo, String descricao, Boolean feito) {

    // Construtor do Record (foi feita uma validação)
    public Todo {
        if (titulo == null || titulo.length() < 3) {
            throw new IllegalArgumentException("Um titulo maior que 3 caracteres é necessário!");
        } 
    }
}
