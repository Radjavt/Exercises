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
                    cadastrarChapas(eleicao, scanner); // erro de entrada na opcao digitar nome da turma e dessa forma não consigo testar o codigo.
                    break;
                case 2:
                    eleicao.comeco();
                    break;
                case 3:
                    eleicao.fim();
                    break;
                case 4:
                    realizarVotacao(eleicao, scanner);
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

    private static void cadastrarChapas(Eleicao eleicao, Scanner scanner) {
        if (!eleicao.comeco() && !eleicao.fim()) {

            System.out.print("Digite o nome da turma: ");
            String turmaNome = scanner.nextLine();

            System.out.print("Digite o nome do líder da chapa: ");
            String lider = scanner.nextLine();

            System.out.print("Digite o nome do vice-líder da chapa: ");
            String vice = scanner.nextLine();

            Chapa chapa = new Chapa(lider, vice);

            if (eleicao.cadastrarChapas(turmaNome, chapa)) {
                System.out.println("Chapa cadastrada com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar a chapa. Verifique se a turma existe ou o processo de votação já foi iniciado.");
            }
        } else {
            System.out.println("Não é possível cadastrar chapas neste momento.");
        }
    }
    private static void realizarVotacao(Eleicao eleicao, Scanner scanner) {
        if (eleicao.comeco() && !eleicao.fim()) {

            System.out.print("Digite o nome da turma: ");
            String turmaNome = scanner.nextLine();

            System.out.print("Digite a matrícula do aluno: ");
            String matriculaAluno = scanner.nextLine();

            Turma turma = (Turma) eleicao.getTurmas().get(turmaNome);

            if (turma != null) {
                List<Chapa> chapas = turma.getChapas();

                System.out.println("Chapas disponíveis:");
                for (int i = 0; i < chapas.size(); i++) {
                    Chapa chapa = chapas.get(i);
                    System.out.println(i + 1 + " - " + chapa);
                }

                System.out.print("Escolha o número da chapa: ");
                int chapaIndex = scanner.nextInt();

                if (eleicao.realizarVotacao(turmaNome, matriculaAluno, chapaIndex - 1)) {
                    System.out.println("Voto registrado com sucesso!");
                } else {
                    System.out.println("Não foi possível registrar o voto. Verifique se a turma existe ou o processo de votação já foi encerrado.");
                }
            } else {
                System.out.println("Turma não encontrada.");
            }
        } else {
            System.out.println("Não é possível realizar votação neste momento.");
        }
    }
}