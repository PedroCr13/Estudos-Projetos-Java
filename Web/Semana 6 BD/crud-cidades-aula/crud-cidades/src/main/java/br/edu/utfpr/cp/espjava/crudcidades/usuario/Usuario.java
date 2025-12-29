package br.edu.utfpr.cp.espjava.crudcidades.usuario;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// implementar a interface UserDetails: define o conjunto de metodos que precisam se implementados por um usuário do sistema

@Entity
public class Usuario implements Serializable,  UserDetails {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    // um usuário pode ter muitos papeis, e cada papel pode estar associando a muitos usuarios
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> papeis;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    public List<String> getPapeis() {
        return papeis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPapeis(List<String> papeis) {
        this.papeis = papeis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        rna uma lista de papéis na qual o usuário tem permissões. Na classe usuario.Usuario, 
        os papéis estão definidos no atributo List papeis. 
        Por isso, precisamos implementar esse método retornando o valor armazenado
         no atributo papeis. Mas não é só isso, o atributo papeis é uma lista de String, 
         enquanto o método getAuthorities() 
         retorna uma coleção de org.springframework.security.core.GrantedAuthority. 
         Por isso, precisamos converter cada papel do tipo String por 
         um org.springframework.security.core.authority.SimpleGrantedAuthority 
        */
        return this.papeis
                    .stream()
                    .map(papelAtual -> new SimpleGrantedAuthority("ROLE_" + papelAtual))
                    .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

}
