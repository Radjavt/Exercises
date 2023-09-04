package ControleMatricula;

public class Disciplina {

    private int codigo;
    private String nome;
    private String horario;
    private Aluno[] listaAlunos;
    private int totalAlunosMatriculados;

    public Disciplina(int codigo, String nome, String horario, int totalAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.horario = horario;
        this.listaAlunos = new Aluno[totalAlunos];
        this.totalAlunosMatriculados = 0;
    }

    public boolean MatricularAluno(Aluno aluno) {
        if (totalAlunosMatriculados >= listaAlunos.length) {
            return false;
        }
        for (int i = 0; i < totalAlunosMatriculados; i++) {
            if (listaAlunos[i].getNrMatricula() == aluno.getNrMatricula()) {
                return false;
            }
        }
        aluno.setStatus('A');
        listaAlunos[totalAlunosMatriculados] = aluno;
        totalAlunosMatriculados++;
        return true;
    }

    public boolean DesmatricularAluno(int nrMatricula){
        for(int i = 0; i < totalAlunosMatriculados; i++) {
            if (listaAlunos[i].getNrMatricula() == nrMatricula) {
                for (int j = 0; j < totalAlunosMatriculados - 1; j++) {
                    listaAlunos[j] = listaAlunos[j + 1];
                }
                listaAlunos[--totalAlunosMatriculados] = null;
                return true;
            }
        }
        return false;
    }

    public float MediaTurma() {
        float somaMedias = 0;
        int numAlunosAtivos = 0;

        for(int i = 0; i < totalAlunosMatriculados; i++){
            if(listaAlunos[i].getStatus()=='A'){
                somaMedias += listaAlunos[i].getMedia();
                numAlunosAtivos++;
            }
        }

        if(numAlunosAtivos == 0) {
            return 0;
        }
        return somaMedias / numAlunosAtivos;
    }

    public boolean TrancarMatricula(int nrMatricula) {
        for (int i = 0; i < totalAlunosMatriculados; i++) {
            if (listaAlunos[i].getNrMatricula() == nrMatricula) {
                listaAlunos[i].setStatus('T');
                return true;
            }
        }
        return false;
    }

    public Aluno[] AlunosAprovados() {
        int countAprovados = 0;
        for(int i = 0; i < totalAlunosMatriculados; i++) {
            if(listaAlunos[i].getMedia()>= 6 && listaAlunos[i].getStatus()== 'A'){
                countAprovados++;
            }
        }

        Aluno[] aprovados = new Aluno [countAprovados];
        int index = 0;
        for (int i = 0; i < totalAlunosMatriculados; i++){
            if(listaAlunos[i].getMedia() >= 6 && listaAlunos[i].getStatus() == 'A'){
                aprovados[index] = listaAlunos[i];
                index++;
            }
        }

        return aprovados;
    }

    public Aluno MaiorMedia() {
        if(totalAlunosMatriculados == 0){
            return null;
        }
        Aluno alunoComMaiorMedia = listaAlunos[0];

        for (int i = 1; i < totalAlunosMatriculados;i++ ){
            if(listaAlunos[i].getMedia()> alunoComMaiorMedia.getMedia() && listaAlunos[i].getStatus() == 'A'){
                alunoComMaiorMedia = listaAlunos[i];
            }
        }
        return alunoComMaiorMedia;
    }
}
