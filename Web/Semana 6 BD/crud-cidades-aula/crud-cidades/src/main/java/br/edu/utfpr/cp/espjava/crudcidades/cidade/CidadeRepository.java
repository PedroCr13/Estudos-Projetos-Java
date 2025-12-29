package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<CidadeEntidade, Long>{

    // Adicionando metódio de busca por nome e estado
    public Optional<CidadeEntidade> findByNomeAndEstado(String nome, String estado);
}
