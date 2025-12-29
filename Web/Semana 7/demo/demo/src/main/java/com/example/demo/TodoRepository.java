package com.example.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

// ReactiveMongoRepository: interface do Spring Data para repositórios reativos

// Esta interface será responsável pelo gerenciamento de dados de tarefas (java Record Todo)
//  ReactiveMongoRepository: herda operacoes básicas de CRUD de org.springframework.data.repository.reactive.ReactiveCrudRepository para MongoDB

// ReactiveMongoRepository<Nome da entidade persistente, Tipo do campo identificador Único>
@Repository
public interface TodoRepository extends ReactiveMongoRepository<Todo, String>{

    // Já herda metodos para criar, alterar, excluir e consultar dados, entre outros

    // os metódos são implementados pelo SpringData

    // Metodo adicionar usando paravras chave de consulta, buscar tarefas pelo status:
    // retorno tipo Flux: tipo que controla uma sequência de dados variando de zero a muitos
    // tipo List não é apropriado para operação não bloqueante
    Flux<Todo> findByFeito(boolean feito);

}
