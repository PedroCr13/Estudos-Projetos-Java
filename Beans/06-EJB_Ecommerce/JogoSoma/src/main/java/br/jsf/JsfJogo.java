package br.jsf;

import br.data.model.Usuario;
import br.ejb.EjbJogo;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
@Named(value = "jsfJogo")
@SessionScoped
public class JsfJogo implements Serializable {

    private String nome;
    private Usuario usuario;
    private int resposta;
    private String mensagem;
    private String mensagemValidacao;
    
    @EJB
    private EjbJogo ejbJogo;
    
    /**
     * Creates a new instance of jsfJogo
     */
    public JsfJogo() {
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagemValidacao() {
        return mensagemValidacao;
    }

    public void setMensagemValidacao(String mensagemValidacao) {
        this.mensagemValidacao = mensagemValidacao;
    }
    
    public String iniciarJogo() {
        
        if (ejbJogo.nomeDeUsuarioEmuso(nome)) {
            mensagemValidacao = "Nome em uso. Escolha outro!";
            return null;
        }
        
        mensagemValidacao = null;
        usuario = new Usuario();
        usuario.setNome(nome);
        
        ejbJogo.adicionarUsuario(usuario);
        ejbJogo.sorteiaNumerosDoJogo(usuario);
        return "index.xhtml?faces-redirect=true";
    }
    
    public int obterNumeroA() {
        return ejbJogo.obterNumeroA(usuario);
    }
    
    public int obterNumeroB() {
        return ejbJogo.obterNumeroB(usuario);
    }
    
    public void validar() {
        boolean acertou = ejbJogo.validarResposta(usuario, resposta);
        if (acertou) {
            mensagem = "Acertou a soma! Pontos acumulados: " + usuario.getPontuacao();
        } else {
            mensagem = "Errou a soma! Correto: " + (obterNumeroA() + obterNumeroB());
        }
        resposta = 0;
        ejbJogo.sorteiaNumerosDoJogo(usuario);
    }
    
    public List<String> getRanking() {
        List<Usuario> ranking = ejbJogo.getRanking();
        List<String> resultado = new ArrayList();
        
        int posicao = 1;
        
        for (Usuario usuarioRanking : ranking) {
            resultado.add(posicao + "." + usuarioRanking.getNome() + " - " +
                    usuarioRanking.getPontuacao());
            posicao++;
        }
        
        return resultado;
    }

}
