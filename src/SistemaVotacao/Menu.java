package SistemaVotacao;

public abstract class Menu {
    public static String getMenu(){
        String menu = ("---------Menu----------\n" +
                "1 - Cadastrar chapas\n" +
                "2 - Iniciar o processo de votação\n" +
                "3 - Encerrar o processo de votação\n" +
                "4 - Realizar uma votação\n" +
                "5 - Emitir resultado\n" +
                "6 - Sair do Sistema");

        return menu;
    }
}