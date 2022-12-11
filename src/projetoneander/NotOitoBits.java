/*
    Not Oito Bits:
        Contem um atributo array de 8 bits do tipo OperacaoNot privado

       Construtor:
            Recebe um argumento do tipo inteiro, o qual eh passado para um valor string binario.
            Podendo possuir entre 1 a 8 posicoes, sendo q sempre vai possuir ao menos uma posicao
            Para armazenar o valor binario primeiro eh criado construtores sem argumento(pre-definidos com o valor 'false')
            ate o contador estar alinhado com a string, entao eh gerado construtores com argumento
            'true' se tiver '1' na respectiva posicao da string, caso contrario eh gerado construtores sem argumento
            A string eh armazenada passando o valor mais significativo para a menor posicao posivel do contador
            Se a string possuir menos de 8 posicoes eh comparado a diferenca do array com a string
            e o atributo do respectivo indice do array recebe o vaor zero
            Quando as posicoes sao alinhadas eh passado o valor da propria string

        Metodo:
            mostraBinario:
                imprime o resultado binario da operacao do mais signitivo ate o menos significativo
*/

package projetoneander;

public class NotOitoBits {
    
    private OperacaoNot[] not;
    
    //construtor
    public NotOitoBits(int num){
        
        this.not = new OperacaoNot[8];
        String bin = Integer.toBinaryString(num);
        
        for(int contador = 0; contador < not.length; contador++){
            if(contador < not.length - bin.length())
                not[contador] = new OperacaoNot();
            
            else{
                if(bin.charAt(contador - not.length - bin.length()) == '1')
                    not[contador] = new OperacaoNot(true);
                
                else not[contador] = new OperacaoNot();
            }
        }
    }
	
	public void mostraBinario(){
		
		System.out.println("bin: ");
                for(int contador = 0; contador < 8; contador++)
                    System.out.println("posicao " + contador + ": " + not[contador].getNot());
	}
        
        public static void main(String[] args){
        
            NotOitoBits nob = new NotOitoBits(1);
            nob.mostraBinario();
        }
}
