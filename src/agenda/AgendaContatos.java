package agenda;

import java.util.ArrayList;

public class AgendaContatos {
    private ArrayList<Contato> contatos;

    public AgendaContatos() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        Contato contatoRemovido = null;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoRemovido = contato;
                break;
            }
        }

        if (contatoRemovido != null) {
            contatos.remove(contatoRemovido);
            System.out.println("Contato " + nome + " removido da agenda.");
        } else {
            System.out.println("Contato com o nome" + nome + " não encontrado na agenda.");
        }
    }

    public String procurarContato(String nome) {
        for(Contato contato : contatos){
            if(contato.getNome().equalsIgnoreCase(nome)){
                return contato.getTelefone();
            }
        }
        return "Contato não encontrado.";
    }

    public void exibirContatos(){
        if(!contatos.isEmpty()){
            System.out.println("Lista de contatos:");
            for(Contato contato : contatos) {
                System.out.println("Nome: "+contato.getNome()+", Telefone: "+contato.getTelefone());
            }
        }else{
            System.out.println("A agenda está vazia.");
        }
    }
}
