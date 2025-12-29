package br.ejb;

import br.data.model.Jogo;
import br.data.model.Usuario;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Startup;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
@Singleton
@LocalBean
@Startup
public class EjbJogo {

    private List<Jogo> jogos = new ArrayList<>();
    private String ultimoLider = null;
   
    @Lock(LockType.WRITE)
    public void adicionarUsuario(Usuario usuario) {
        Jogo jogo = new Jogo(usuario);
        jogos.add(jogo);
    }
     
    public void sorteiaNumerosDoJogo(Usuario usuario) {
        for (Jogo j : jogos) {
            if (j.getUsuario().getNome().equalsIgnoreCase(usuario.getNome())) {
                j.sorteiaNumeros();
            }
        }
    }
    
    public int obterNumeroA(Usuario usuario) {        
        int numeroSorteado = 0;
        
        for (Jogo j : jogos) {
            if (j.getUsuario().getNome().equalsIgnoreCase(usuario.getNome())) {
                numeroSorteado = j.getNumeroA();
            }
        }
        return numeroSorteado;
    }
    
    public int obterNumeroB(Usuario usuario) {
       int numeroSorteado = 0;
        
        for (Jogo j : jogos) {
            if (j.getUsuario().getNome().equalsIgnoreCase(usuario.getNome())) {
                numeroSorteado = j.getNumeroB();
            }
        }
        return numeroSorteado;
    }
    
    @Lock(LockType.WRITE)
    public boolean validarResposta(Usuario usuario, int resposta) {
        boolean acertou = false;
        
        for (Jogo j : jogos) {
            if (j.getUsuario().getNome().equalsIgnoreCase(usuario.getNome())) {
               acertou = j.validaCalculo(resposta);
            }
        }
        return acertou;
    }
    
    public boolean nomeDeUsuarioEmuso(String nome) {
        boolean encontrou = false;
        
        for (Jogo j : jogos) {
            if (j.getUsuario().getNome().equalsIgnoreCase(nome)) {
               encontrou = true;
               break;
            }
        }
        return encontrou;
    }
    
    @Lock(LockType.READ)
    public List<Usuario> getRanking() {
        return jogos.stream()
                    .map(Jogo::getUsuario)
                    .sorted(Comparator.comparingInt(Usuario::getPontuacao).reversed()
                    .thenComparing(Usuario::getNome)) // Desempate ordena por nome
                    .toList();
    }
    
    public boolean verificaNovoLider() {
        List<Usuario> ranking = getRanking();
        if (!ranking.isEmpty()) {
            String novoLider = ranking.get(0).getNome();
            if (ultimoLider == null || !ultimoLider.equals(novoLider)) {
                ultimoLider = novoLider;
                return true;
            }
        }
        return false;
    }
}
