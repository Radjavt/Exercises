package ControleMatricula;

public class Main {

    public static void main(String[] args) {
        // Criar alguns objetos Aluno
        Aluno aluno1 = new Aluno(1, "Gabriel", 7.5f);
        Aluno aluno2 = new Aluno(2, "Adrian", 9.8f);
        Aluno aluno3 = new Aluno(3, "Isaac", 8.2f);

        // Criar uma disciplina
        Disciplina disciplina = new Disciplina(101, "Matemática", "Segunda-feira 8:00", 10);

        // Matricular os alunos na disciplina
        disciplina.MatricularAluno(aluno1);
        disciplina.MatricularAluno(aluno2);
        disciplina.MatricularAluno(aluno3);

        // Exibir a média da turma
        System.out.println("Média da Turma: " + disciplina.MediaTurma());

        // Exibir alunos aprovados na disciplina
        Aluno[] aprovados = disciplina.AlunosAprovados();
        System.out.println("Alunos Aprovados:");
        for (Aluno aluno : aprovados) {
            System.out.println(aluno.getNome());
        }

        // Exibir o aluno com a maior média na disciplina
        Aluno alunoMaiorMedia = disciplina.MaiorMedia();
        if (alunoMaiorMedia != null) {
            System.out.println("Aluno com a Maior Média: " + alunoMaiorMedia.getNome());
        } else {
            System.out.println("Nenhum aluno encontrado na disciplina.");
        }

        // Trancar a matrícula de um aluno
        int nrMatriculaAExcluir = 2;
        boolean desmatriculado = disciplina.TrancarMatricula(nrMatriculaAExcluir);
        if (desmatriculado) {
            System.out.println("Aluno com matrícula " + nrMatriculaAExcluir + " foi trancado.");
        } else {
            System.out.println("Aluno com matrícula " + nrMatriculaAExcluir + " não encontrado ou já trancado.");
        }
    }
}
