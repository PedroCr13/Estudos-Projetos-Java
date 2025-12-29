package local.redes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class BancoDeVotos {
    
    private List<CadastroCandidatoUrna> cadastroDeCandidatos;
    
    public BancoDeVotos() {
        cadastroDeCandidatos = new ArrayList<CadastroCandidatoUrna>();
    }
    
    public void adicionarCandidato(Candidato c) throws CandidatoExisteException {
        for (CadastroCandidatoUrna cadastro : cadastroDeCandidatos) {
            if (cadastro.getCandidato().getNome().equalsIgnoreCase(c.getNome())) {
                throw new CandidatoExisteException("Nome de candidato já existe!");
            }
            if (cadastro.getCandidato().getNumeroDoPartido() == c.getNumeroDoPartido()) {
                throw new CandidatoExisteException("Numero de candidato já existe!");
            }
        }
        cadastroDeCandidatos.add(new CadastroCandidatoUrna(c));
    }
    
    public void adicionarVotos(int numeroPartido, int qtdVotos) {
         for (CadastroCandidatoUrna cadastro : cadastroDeCandidatos) {
             if (cadastro.getCandidato().getNumeroDoPartido() == numeroPartido) {
                cadastro.adicionaVotos(qtdVotos);
             }
         }
    }
    
    public List<Candidato> obterListaDeCandidatos() {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        
        for (CadastroCandidatoUrna cadastro : cadastroDeCandidatos) {
            candidatos.add(cadastro.getCandidato());
        }
        return candidatos;
    }
   
    public void exibirVotosPorCandidato() {
        String nome = "";
        int numeroPartido = 0;
        int qtdVotos = 0;
        
        if (cadastroDeCandidatos == null || cadastroDeCandidatos.size() == 0) {
            System.out.println("Não há candidatos cadastrados");
            return;
        }
        
        System.out.println(" Eleição ");
        System.out.println(" Votos Apurados ###");
        for (CadastroCandidatoUrna cadastro : cadastroDeCandidatos) {
            nome = cadastro.getCandidato().getNome();
            numeroPartido = cadastro.getCandidato().getNumeroDoPartido();
            qtdVotos = cadastro.getQuantidadeDeVotos();
            System.out.println(numeroPartido + " " + nome + " -- " + qtdVotos);
        }
        System.out.println("--------------------------------------------");
    }
}
