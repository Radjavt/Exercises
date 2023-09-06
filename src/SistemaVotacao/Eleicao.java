package SistemaVotacao;

import java.util.HashMap;
import java.util.Map;

public class Eleicao {
    private Map<String, Turma> turmas;
    private Map<String, Aluno> alunos;
    private Map<String, Professor> professores;
    private boolean votacaoAberta;

    public Eleicao() {
        turmas = new HashMap<>();
        alunos = new HashMap<>();
        professores = new HashMap<>();
        votacaoAberta = false;
    }

    public void registrarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    public void registrarProfessor(Professor professor) {
        professores.put(professor.getMatricula(), professor);
    }


    public void cadastrarChapas(String turmaNome, String lider1, String vice1, String lider2, String vice2) {
        if (votacaoAberta) {
            System.out.println("Não é possível cadastrar chapas durante a votação.");
            return;
        }

        Turma turma = turmas.get(turmaNome);

        if (turma == null) {
            criarTurma(turmaNome);
            turma = turmas.get(turmaNome);
        }

        turma.cadastrarChapa(new Chapa(lider1, vice1));
        turma.cadastrarChapa(new Chapa(lider2, vice2));
        System.out.println("Chapas cadastradas com sucesso na turma " + turmaNome);
    }


    public void criarTurma(String turmaNome) {
        if (turmas.containsKey(turmaNome)) {
            System.out.println("Turma já existe.");
            return;
        }

        turmas.put(turmaNome, new Turma(turmaNome));
        System.out.println("Turma " + turmaNome + " criada com sucesso.");
    }

    public void iniciarProcessoDeVotacao(String turma) {
        if (votacaoAberta) {
            System.out.println("O processo de votação já foi iniciado.");
        } else {
            votacaoAberta = true;
            System.out.println("Processo de votação iniciado.");
        }
    }

    public void encerrarProcessoDeVotacao(String turmaEncerrar) {
        if (!votacaoAberta) {
            System.out.println("O processo de votação ainda não foi iniciado.");
        } else {
            votacaoAberta = false;
            System.out.println("Processo de votação encerrado.");
        }
    }

    public void realizarVotacao(String turmaNome, int chapaNumero) {
        Turma turma = turmas.get(turmaNome);

        if (turma == null) {
            System.out.println("Turma não existe.");
            return;
        }

        turma.votar(chapaNumero);
    }


    public void emitirResultado() {
        if (votacaoAberta) {
            System.out.println("O processo de votação ainda está em andamento.");
            return;
        }

        for (Turma turma : turmas.values()) {
            System.out.println("Resultado da turma " + turma.getNome() + ":");
            turma.emitirResultado();
            System.out.println();
        }
    }
}