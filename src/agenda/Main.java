package agenda;
public class Main {
    public static void main(String[] args) {
        Contato contato1 = new Contato("79996477488", "Radija");
        Contato contato2 = new Contato("79996477482", "Maria");

        AgendaContatos agenda = new AgendaContatos();
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);

        agenda.exibirContatos();

        System.out.println("Telefone de Maria: "+agenda.procurarContato("Maria"));

        agenda.removerContato("Radija");

        agenda.exibirContatos();
    }
}

