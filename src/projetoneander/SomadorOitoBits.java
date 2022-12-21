/*
Somador Oito Bits:
    
    Obs.:   A soma tem q ser feita de tras para a frente(com a setima posicao do SC
    recebendo a posicao mais a direita das string(bin, bin2)), com a excessao da primeira operacao
    todas as outras vao receber o carryIn da anterior.
    
    Tem um atributo privado array de oito bits do formato SomadorCompleto
    
    Construtor:
        Tem dois argumentos do tipo int(num, num2), que sao passado para uma string(bin, bin2) no formato binario string
        eh feito um laco para alinhar a posicao e efetuar a soma

    Alteracoes 20/12:
        -As string bin e bin2 qnd n tiverem o tamanho igual ao esperado pelo SomadorCompleto, sao preenchidas com zeros a esquerda
        - o laco for(l:55) foi invertido de 0 ate 7 para 7 ate 0
        na segunda condicao if(l:63) se o carryin for 'true' ocorre problema
*/

package projetoneander;

import java.util.Scanner;

public class SomadorOitoBits {
    
    private SomadorCompleto sc[];
    
    //construtor
    public SomadorOitoBits(int num, int num2) throws Intervalo_Exception{
    
        this.sc = new SomadorCompleto[8];
        
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);
                
        int tam = sc.length - bin.length(); //tam recebe a diferenca de tamanho do sc pelo bin
        
        //se a string bin for menor q 8 preenche com "0" a esquerda ate fechar oito
        if(bin.length() < sc.length){   
            for(int c = 0; c < tam; c++){
        
                bin = "0".concat(bin);
            }
        }
        
        //se a string bin2 for menor q 8 preenche com "0" a esquerda ate fechar oito
        tam = sc.length - bin2.length();
        if(bin2.length() < sc.length){
            for(int c = 0; c < tam; c++){
            
                bin2 = "0".concat(bin2);
                
            }
        }
        
        //ci(carryin) = n pode receber sc[contador + 1].carry() dentro do laco(estouro na primeira tentativa[7+1])
        boolean carryin = false;
        for(int contador = sc.length - 1; contador >= 0; contador--){                        
            if(bin.charAt(contador) == '0' && bin2.charAt(contador) == '0'){

                sc[contador] = new SomadorCompleto(carryin);
            }
            else if(bin.charAt(contador) == '1' && bin2.charAt(contador) == '1'){
            
                // carryin = false :sc[c].soma() = 0 :sc[c].carry() = 1
                // carryin = true :sc[c].soma() = 1 :sc[c].carry() = 1
                sc[contador] = new SomadorCompleto(carryin, true, true);
                


            }else{  //caso bin e bin2 sejao diferentes somente carryin altera o resultado
            
                sc[contador] = new SomadorCompleto(carryin, true);                

            }
            
            carryin = sc[contador].carry();
        }
    }
    
    public void mostraBinario(){
    
        System.out.println("bin:");
        for(int contador = 0; contador < sc.length; contador++){
        
            System.out.println("Posicao " + contador + ": " + sc[contador].soma());
        }
    }
    
    public static void main(String[] args){
    
        
        /*
                                       0123 4567
        *0000 0001(1) + 0000 0001(1) = 0000 0010(2)
        *0000 0011(3) + 0000 0001(1) = 0000 0100(4)
        *0000 0011(3) + 0000 0011(3) = 0000 0110(6)
        */
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o num: ");
        int num = entrada.nextInt();
        
        System.out.print("Digite o num2: ");
        int num2 = entrada.nextInt();
        
        try{
            if(num < 0 || num >= 256) throw new Intervalo_Exception("Valor de num esta fora do intervalo");
            if(num2 < 0 || num2 >= 256) throw new Intervalo_Exception("Valor de num2 esta fora do intervalor");
        SomadorOitoBits sob = new SomadorOitoBits(num, num2);
        sob.mostraBinario();
        }catch(Intervalo_Exception E){
            
            System.err.println(E);
        }
    }
}
