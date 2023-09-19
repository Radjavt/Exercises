package TratamentoExcecoes;

public class CalculoMatematico {
    public int divisao(int dividend, int divider) throws DivisorZeroException{
        if(divider == 0 ){
            throw new DivisorZeroException();
        }
        return dividend/divider;
    }
}