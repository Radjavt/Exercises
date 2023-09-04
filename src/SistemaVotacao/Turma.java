package SistemaVotacao;

import java.util.List;

public class Turma {
    private String nome;
    private List<Chapa> chapas;
    public Turma(String nome, List<Chapa> chapas) {
        this.nome = nome;
        this.chapas = chapas;
    }

    public boolean adicionarChapa(Chapa chapa){
      if(chapas.size()< 2){
          chapas.add(chapa);
          return true;
      }
      return false;
    }

    public String getNome() {
        return nome;
    }

    public List<Chapa> getChapas() {
        return chapas;
    }
}