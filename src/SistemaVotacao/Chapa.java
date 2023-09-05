package SistemaVotacao;

public class Chapa {

    private String lider;
    private String vice;
    private int votos;

    public Chapa(String lider, String vice) {
        this.lider = lider;
        this.vice = vice;
        this.votos = 0;
    }

    public void receberVoto() {
        votos++;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return "Líder: " + lider + ", Vice-Líder: " + vice;
    }
}