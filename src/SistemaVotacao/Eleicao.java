package SistemaVotacao;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Eleicao {

    private Map<String, Turma> turmas;
    private boolean votacaoInicio;
    private boolean votacaoFim;
    public Eleicao() {
        this.turmas = new HashMap<>();
        this.votacaoInicio = false;
        this.votacaoFim = false;
    }
    public boolean cadastrarChapas(String turmaNome, Chapa chapa) {
        if (turmas.containsKey(turmaNome) && !votacaoInicio) {
            Turma turma = turmas.get(turmaNome);
            return turma.adicionarChapa(chapa);
        }
        return false;
    }
    public boolean comeco(){
        votacaoInicio = true;
        return false;
    }
    public boolean fim(){
        votacaoFim = true;
        return false;
    }
    public boolean realizarVotacao(String turmaNome, String matriculaAluno, int chapaIndex){
       if(turmas.containsKey(turmaNome) && !votacaoFim){
           Turma turma = turmas.get(turmaNome);
           List<Chapa> chapas = turma.getChapas();
           if(chapaIndex >= 0 && chapaIndex < chapas.size()){
               Chapa chapa = chapas.get(chapaIndex);
               chapa.incrementarVotos();
               return true;
           }
           }
        return false;
    }
    public void emitirResultado(){
        if(votacaoFim){
        for(Map.Entry<String, Turma>entry : turmas.entrySet()) {
            String turmaNome = entry.getKey();
            Turma turma = entry.getValue();
            System.out.println("Resultado da turma: "+turmaNome);
            List<Chapa> chapas = turma.getChapas();
            int totalVotos = chapas.stream().mapToInt(Chapa::getVotos).sum();
            for(int i = 0; i < chapas.size(); i++){
                Chapa chapa = chapas.get(i);
                double porcen = (double) chapa.getVotos() / totalVotos * 100;
                System.out.println("Chapa "+(i + 1)+": "+porcen+"% dos votos");
            }
          }

        }
    }
    public Map<Object, Object> getTurmas() {
        return null;
    }
}