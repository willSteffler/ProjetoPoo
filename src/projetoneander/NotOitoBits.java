/*
    Not Oito Bits:
        Contem um atributo array de 8 bits do tipo OperacaoNot privado(l27)
        Possui apenas um construtor q recebe apenas um argumentos(int num)(l30)
        Possui apenas um metodo, q n possui argumentos e n retorna nada(l51)

       Construtor:
            Define o array not com 8 espacos(l32)
            Passa num de inteiro para binario em uma string(l33)
            Int tam define a diferenca entre o tamanho do array e da string(l35)
            Se o tamanho da string for menor q o do array um laco
            vai preencher com zeros a esquerda(l36)
            Laco repete 8 vezes(not.length) instanciando cada posicao do array
            com true ou false.(l43)

        Metodo:
            mostraBinario:
                imprime o resultado binario da operacao do mais signitivo ate o 
                menos significativo(l55)
*/

package projetoneander;

import java.util.Scanner;

public class NotOitoBits {
    
    private OperacaoNot[] not;
    
    //construtor
    public NotOitoBits(int num) throws Intervalo_Exception{
        
        this.not = new OperacaoNot[8];
        String bin = Integer.toBinaryString(num);
        
        int tam = not.length - bin.length();
        if(bin.length() < not.length){
            for(int c = 0; c < tam; c++){
            
                bin = "0".concat(bin);
            }
        }
        
        for(int contador = 0; contador < not.length; contador++){
            if(bin.charAt(contador) == '0')
                not[contador] = new OperacaoNot();
            
            else not[contador] = new OperacaoNot(true);
        }
    }
	
	public void mostraBinario(){
		
		System.out.println("bin: ");
                for(int contador = 0; contador < 8; contador++)
                    System.out.println("posicao " + contador + ": " + not[contador].getNot());
	}
        
        public static void main(String[] args){
        
            
            Scanner entrada = new Scanner(System.in);
            
            System.out.print("Digite o num: ");
            int num = entrada.nextInt();
            
            try{
                if(num < 0 || num >= 256) throw new Intervalo_Exception("Fora do intervalo");
            NotOitoBits nob = new NotOitoBits(num);
            nob.mostraBinario();
            }catch(Intervalo_Exception E){
        
                System.err.println(E);
            }
        }
}
