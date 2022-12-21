/*
Or Oito Bits:
    Possui um atributo privado array de 8 posicoes do tipo operacaoOr(l25)
    Tem apenas um construtor q tem dois argumentos(int num, int num2)(l28)
    Tem apenas um metodo q n recebe argumentos e n retorna nada(l56)

    Construtor:
        Define o tamanho do array or em 8(l30)
        String bin e bin2 recebem o valor de num e num2 em binario(l31 l32)
        Int tam define a diferenca do tamanho da array or com bin e 
        bin2(l34 l41)
        Se bin e bin2 for menor q o array or sao preenchidos com zeros a 
        esquerda(l35 l42)
        Laco com tamanho 8 instancia cada posicao de or com true se qlqr um dos 
        valores for '1'(l48)

    MostraBinario:
        Imprime o resultado binario de cada posicao do mais significativo para o
        menos significativo(l61)
 */
package projetoneander;

import java.util.Scanner;

public class OrOitoBits {

    private OperacaoOr or[];

    //construtor
    public OrOitoBits(int num, int num2) throws Intervalo_Exception {

        this.or = new OperacaoOr[8];
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);

        int tam = or.length - bin.length();
        if (bin.length() < or.length){
            for(int c = 0; c < tam; c++)
                
                bin = "0".concat(bin);
        }
        
        tam = or.length - bin2.length();
        if(bin2.length() < or.length){
            for(int c = 0; c < tam; c++)
            
                bin2 = "0".concat(bin2);
        }

        for (int contador = 0; contador < or.length; contador++) {
            if (bin.charAt(contador) == '1'|| bin2.charAt(contador) == '1')
                
                or[contador] = new OperacaoOr(true);
            else or[contador] = new OperacaoOr();
        }
    }

    public void mostraBinario() {

        System.out.println("bin: ");
        for (int count = 0; count < or.length; count++) {
            System.out.println("Posicao " + count + ": " + or[count].getOr());
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o num: ");
        int num = entrada.nextInt();

        System.out.print("Digite o num2: ");
        int num2 = entrada.nextInt();

        try {

            if (num < 0 || num >= 256) {
                throw new Intervalo_Exception("Valor de num esta fora do intervalo");
            }
            if (num2 < 0 || num2 >= 256) {
                throw new Intervalo_Exception("Valor de num2 esta fora do intervalo");
            }

            OrOitoBits oob = new OrOitoBits(num, num2);
            oob.mostraBinario();
        } catch (Intervalo_Exception E) {

            System.err.println(E);
        }
    }
}
