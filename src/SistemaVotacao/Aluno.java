package SistemaVotacao;

public class Aluno {
    private String matricula;
    private String turma;

    public Aluno(String matricula, String turma) {
        this.matricula = matricula;
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTurma() {
        return turma;
    }
}