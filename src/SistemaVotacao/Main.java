package SistemaVotacao;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

    Eleicao eleicao = new Eleicao();
    Scanner scanner = new Scanner(System.in);

        System.out.println(Menu.getMenu());
        System.out.println("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        while (true) {
            switch (opcao) {
                case 1:
                    System.out.print("Nome da turma: ");
                    scanner.nextLine();
                    String turmaNome = scanner.nextLine();
                    System.out.print("Nome do líder 1: ");
                    String lider1 = scanner.nextLine();
                    System.out.print("Nome do vice-líder 1: ");
                    String vice1 = scanner.nextLine();
                    System.out.print("Nome do líder 2: ");
                    String lider2 = scanner.nextLine();
                    System.out.print("Nome do vice-líder 2: ");
                    String vice2 = scanner.nextLine();
                    eleicao.cadastrarChapas(turmaNome, lider1, vice1, lider2, vice2);
                    break;
                case 2:
                    System.out.print("Nome da turma: ");
                    scanner.nextLine();
                    String turma = scanner.nextLine();
                    eleicao.iniciarProcessoDeVotacao(turma);
                    break;
                case 3:
                    System.out.print("Nome da turma: ");
                    scanner.nextLine();
                    String turmaEncerrar = scanner.nextLine();
                    eleicao.encerrarProcessoDeVotacao(turmaEncerrar);;
                    break;
                case 4:
                    System.out.print("Nome da turma: ");
                    scanner.nextLine();
                    String turmaVotar = scanner.nextLine();
                    System.out.print("Número da chapa: ");
                    int chapaNumero = scanner.nextInt();
                    eleicao.realizarVotacao(turmaVotar, chapaNumero);
                    break;
                case 5:
                    eleicao.emitirResultado();
                    break;
                case 6:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println(Menu.getMenu());
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
        }
    }
}