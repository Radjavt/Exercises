package SistemaVotacao;

public class Chapa {
    private String lider;
    private String vice;
    private int votos;

    public Chapa(String lider, String vice) {
        this.lider = lider;
        this.vice = vice;
        this.votos = votos;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementarVotos() {
        votos++;
    }

}