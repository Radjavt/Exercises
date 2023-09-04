package ControleMatricula;

public class Aluno {

    private int nrMatricula;
    private String nome;
    private char status;
    private float media;

    public Aluno(int nrMatricula, String nome, float media) {
        this.nrMatricula = nrMatricula;
        this.nome = nome;
        this.status = status;
        this.media = media;
    }

    public int getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(int nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
