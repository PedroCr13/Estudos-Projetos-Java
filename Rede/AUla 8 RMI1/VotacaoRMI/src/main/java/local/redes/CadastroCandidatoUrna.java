package local.redes;

/**
 *
 * @author Pedro Cristovão Lopes Fogaça
 */
public class CadastroCandidatoUrna {
    private Candidato candidato;
    private int quantidadeDeVotos;

    public CadastroCandidatoUrna(Candidato c) {
        candidato = c;
        quantidadeDeVotos = 0;
    }
    
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getQuantidadeDeVotos() {
        return quantidadeDeVotos;
    }

    public void adicionaVotos(int quantidadeDeVotos) {
        this.quantidadeDeVotos +=  quantidadeDeVotos;
    }    
}
