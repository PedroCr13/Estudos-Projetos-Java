package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// o controlador tem a responsabilidade de gerenciar a interação entre o usuário e a API
// neste projeto os metodos do controlador agem com delegador de solicitações 
// (apenas expoe os endereços da API e repassam informações para interface de persistência)

// @RestController: Identifica a classe com controlador que atende solicitações Rest
@RestController
public class TodoRestController {
    
    private final TodoRepository repository;

    /*
        A classe tem ainda um construtor que recebe TodoRepository como argumento. 
        Esse construtor é usado pelo Spring para injetar a dependência no atributo repository. 
        Assim, como vimos anteriormente, a injeção de dependência é uma característica marcante do Spring. 
        Note que não precisamos instanciar TodoRepository em nenhum momento
    */
    public TodoRestController(final TodoRepository repository) {
        this.repository = repository;
        
    }
    
    // @GetMapping: associa o método subsequente com uma solicitação HTTP do tipo GET para a URL
    // informada como parâmetro na anotação
    @GetMapping("/todos")
    public Flux<Todo> lerTodos() {
        // listar as tarefas existentes na base de dados
        return repository.findAll();
    }

    @GetMapping("/todos/{feito}")
    public Flux<Todo> lerByFeito(@PathVariable boolean feito) {
        return repository.findByFeito(feito);
    }

    // Retorna apenas UMA tarefa (Mono)
    // Mono suporta carregar apenas um objeto, neste caso a tarefa que foi criada
    // @RequestBody: associa um objeto JSON enviado no corpo da solicitação REST com o objeto informado no parâmetro do método atual (Todo).
    @PostMapping("/todos")
    public Mono<Todo> criar(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    // {id} representa um identificado de uma tarefa especifica
    // retorna um retorno vazio (void), a tarefa acabou de ser eliminada, não há o que retornar
    @DeleteMapping("/todos/{id}")
    public Mono<Void> deletar(@PathVariable String id) {
        return repository.deleteById(id);
    }

    // {id} representa um identificado de uma tarefa especifica
    // carrega a tarefa correspondente ao Id, é criada uma nova tarefa com os mesmos dados, mas atributo feito alterado
    @PutMapping("/todos/{id}")
    public Mono<Todo> atualizar(@PathVariable String id) {
        return repository
                    .findById(id)
                    .map(todoAtual -> new Todo(id, 
                                            todoAtual.titulo(), 
                                            todoAtual.descricao(), 
                                            !todoAtual.feito()))
                    .flatMap(repository::save)
                    .onTerminateDetach();
    }
    
}
