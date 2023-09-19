package TratamentoExcecoes;

public class DivisorZeroException extends Exception{
    public String getMessage() {
        return "A operação não pode ser realizada devido a uma divisão por zero.";
    }
}