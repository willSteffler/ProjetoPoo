/*
Or Oito Bits:
    Possui um atributo privado array de 8 posicoes do tipo operacaoOr

    Construtor:
        Possui dois argumentos do tipo int(num e num2) que sao passados para strings binarias(bin e bin2)
        Sendo que bin sempre recebe o maior valor.

        Eh feito um laco para ajusta a posicao da maior string com o array
        Como o valor '1' eh o controle o que tiver na maior string eh sempre passado para frente
*/

package projetoneander;

public class OrOitoBits {
    
    private OperacaoOr or[];
    
    //construtor
    public OrOitoBits(int num, int num2){
    
        this.or = new OperacaoOr[8];
        String bin;
        String bin2;
        
        if(num > num2){
            
            bin = Integer.toBinaryString(num);
            bin2 = Integer.toBinaryString(num2);
        }else{
        
            bin = Integer.toBinaryString(num2);
            bin2 = Integer.toBinaryString(num);
        } 
        
        for(int contador = 0; contador < or.length; contador++){
            if(contador < or.length - bin.length())
            
                or[contador] = new OperacaoOr();
            else if(contador >= or.length - bin2.length()){
                if(bin.charAt(contador) == '1' || bin2.charAt(contador) == '1')

                    or[contador] = new OperacaoOr(true);
                else or[contador] = new OperacaoOr();        
            }else if(bin.charAt(contador) == '1')
                
                or[contador] = new OperacaoOr(true);
            else or[contador] = new OperacaoOr();
        }
    }
    
    public void mostraBinario(){
    
        System.out.println("bin: ");
        for(int count = 0; count < or.length; count++)
            System.out.println("Posicao " + count + ": " + or[count].getOr());
    }
    
    public static void main(String[] args){
    
        OrOitoBits oob = new OrOitoBits(255, 1);
        oob.mostraBinario();
    }
}
