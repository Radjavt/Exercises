package SistemaVotacao;

import java.util.ArrayList;
import java.util.List;
public class Turma {

    private String nome;
    private List<Chapa> chapas;
    private boolean votacaoAberta;

    public Turma(String nome) {
        this.nome = nome;
        chapas = new ArrayList<>();
        votacaoAberta = false;
    }

    public void cadastrarChapa(Chapa chapa) {
        if (votacaoAberta) {
            System.out.println("Não é possível cadastrar chapas durante a votação.");
            return;
        }

        if (chapas.size() < 2) {
            chapas.add(chapa);
            System.out.println("Chapa cadastrada com sucesso.");
        } else {
            System.out.println("Não é possível cadastrar mais chapas nesta turma.");
        }
    }

    public void iniciarVotacao() {
        votacaoAberta = true;
    }

    public void encerrarVotacao() {
        votacaoAberta = false;
    }

    public void votar(int chapaNumero) {
        if (chapaNumero < 1 || chapaNumero > chapas.size()) {
            System.out.println("Número de chapa inválido.");
            return;
        }

        Chapa chapa = chapas.get(chapaNumero - 1);
        chapa.receberVoto();
        System.out.println("Voto registrado com sucesso.");
    }


    public void emitirResultado() {
        if (!votacaoAberta) {
            for (Chapa chapa : chapas) {
                System.out.println("Chapa " + chapa + ": " + chapa.getVotos() + " votos");
            }
        } else {
            System.out.println("A votação para esta turma ainda não foi encerrada.");
        }
    }

    public String getNome() {
        return nome;
    }
}