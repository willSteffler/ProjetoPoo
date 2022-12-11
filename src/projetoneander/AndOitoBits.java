/*
And Oito Bits:

    Tem um atributo privado array de oito bits and do formato OperacaoAnd

    Construtor:
        Ha dois argumentos do formato int(num, num2), que sao passado para o formato
        binario stringe salvos respectivamente em bin e bin2
        Ocorre um ajusto em um laco para alinhar os bits da operacao and com
        os bits de entrada(que nem sempre sao 8)
        Quando o contador encontra a primeira posicao do bin ainda eh passado
        o valor 'false' pois eh o controle da and, quando o contador encontra 
        a primeira posicao do bin2 eh feita uma comparacao e sempre q tiver um 
        valor 0 eh invacado o construtor sem argumentos(valor 'false' por padrao).
*/

package projetoneander;

public class AndOitoBits {
   
    private OperacaoAnd and[];
    
    public AndOitoBits(int num, int num2){
    
        this.and = new OperacaoAnd[8];
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);
        
        int conta = and.length - bin.length();
        int conta2 = and.length - bin2.length();
        for(int contador = 0; contador < and.length; contador++){
            if(contador < and.length - bin.length() && contador < and.length - bin2.length()){
                
                and[contador] = new OperacaoAnd();
            }else if(contador - conta < 0  || contador - conta2 < 0){
                
                and[contador] = new OperacaoAnd();
            }else if(conta > conta2){
                if(bin.charAt(contador - conta) == '0' || bin2.charAt(contador - conta2) == '0'){
                    
                    and[contador] = new OperacaoAnd();
                }else{
                    
                    and[contador] = new OperacaoAnd(true);
                }
            }else{
                if(bin.charAt(contador - conta) == '0' || bin2.charAt(contador - conta2) == '0')
                    and[contador] = new OperacaoAnd();
                
                else and[contador] = new OperacaoAnd(true);
            }
        }
    }
    
    public void mostraBinario(){
    
        System.out.println("bin: ");
        for(int contador = 0; contador < and.length; contador++)
            System.out.println("Posicao " + contador + ": " + and[contador].getAnd());
    }
    
    public static void main(String[] args){
    
        AndOitoBits aob = new AndOitoBits(0, 254);
        aob.mostraBinario();
    }
}