package br.edu.utfpr.cp.espjava.crudcidades.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface que gerencia as operações de persistência

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByNome(String nome);

}
    
