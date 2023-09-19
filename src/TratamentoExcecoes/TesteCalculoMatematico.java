package TratamentoExcecoes;

public class TesteCalculoMatematico {
    public static void main(String[] args) {
        CalculoMatematico calculo = new CalculoMatematico();
        try {
            int resultado = calculo.divisao(4, 2);
            System.out.println("Resultado da divisão: " + resultado);
        } catch (DivisorZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}