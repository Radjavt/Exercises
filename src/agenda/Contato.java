package agenda;
public class Contato{
    private String telefone;
    private String nome;

    public Contato(String telefone, String nome) {
        this.telefone = telefone;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String contato) {
        this.telefone = contato;
    }
}