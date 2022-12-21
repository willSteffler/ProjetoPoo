/*
And Oito Bits:

    Tem um atributo privado array de oito bits and do formato OperacaoAnd(l25)
    Possui apenas um construtor q recebe dois argumentos(int num, int num2)(l27)
    Possui apenas um metodo q n recebe nada e n retorna nada(l55)


    Construtor:
        Define o array and com 8 espacos(l29)
        String bin e bin2 recebem num e num2  no formato binario(l30 l31)
        Int tam define a diferenca do tamanho de and e bin(l33 e depois de bin2(l40)
        Se bin e bin2 for menor q o array and um laco preenche com zeros a 
        esquerda ate ter 8 posicoes(l34 l41)
        Laco repete 8 vezes se for achado um '0' instancia a posicao com false(l47)

    MostraBinario:
        Imprime o resultado binario da operacao do mais significativo ate o 
        menos significativo(l59)

*/

package projetoneander;

import java.util.Scanner;

public class AndOitoBits {
   
    private OperacaoAnd and[];
    
    //construtor
    public AndOitoBits(int num, int num2) throws Intervalo_Exception{
    
        this.and = new OperacaoAnd[8];
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);
        
        int tam = and.length - bin.length();        
        if(bin.length() < and.length){
            for(int c = 0; c < tam; c++)
                
                bin = "0".concat(bin);
        }
        
        tam = and.length - bin2.length();        
        if(bin2.length() < and.length){
            for(int c = 0; c < tam; c++)
            
                bin2= "0".concat(bin2);
        }
        
        for(int contador = 0; contador < and.length; contador++){
            if(bin.charAt(contador) == '0' || bin2.charAt(contador) == '0')
                
                and[contador] = new OperacaoAnd();
            else and[contador] = new OperacaoAnd(true);
        }
    }
    
    public void mostraBinario(){
    
        System.out.println("bin: ");
        for(int contador = 0; contador < and.length; contador++)
            System.out.println("Posicao " + contador + ": " + and[contador].getAnd());
    }
    
    public static void main(String[] args){
    
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o num: ");
        int num = entrada.nextInt();
        
        System.out.print("Digite o num2: ");
        int num2 = entrada.nextInt();
        
        try{
            if(num < 0 || num >=256) throw new Intervalo_Exception("Valor de num fora do intervalo");
            if(num2 < 0 || num2 >= 256) throw new Intervalo_Exception("Valor de num2 fora do intervalo");
            AndOitoBits aob = new AndOitoBits(num, num2);
            aob.mostraBinario();
        }catch(Intervalo_Exception E){
        
            System.err.println(E);
        }
    }
}