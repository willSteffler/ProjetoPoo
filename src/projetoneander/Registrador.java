/*
* necessario fazer mudanças no flipflop para simplificar o funcionamento do registrador
* necessario olhar Intervalo_exception
 */
package projetoneander;

import FlipFlop.FlipFlopRS;
import java.util.Scanner;

public class Registrador {
    
    private FlipFlopRS ff[];
    
    public Registrador(int valor) throws Intervalo_Exception{
        this.ff = new FlipFlopRS[8];
        String bin = Integer.toBinaryString(valor);
        
        while(bin.length() < ff.length){
            bin = "0".concat(bin);
        }
        
        for(int c = 0; c < bin.length(); c++){
            if(bin.charAt(c) == '0')
                ff[c] = new FlipFlopRS(false, false);
            else ff[c] = new FlipFlopRS(false, true);
        }
    }
    
    public Registrador(String ponteiro){
    
        ff = new FlipFlopRS[8];
        
        if(ponteiro.length() < ff.length){
            for(int c = 0; c < ff.length - ponteiro.length(); c++)
                ponteiro = "0".concat(ponteiro);       
        }
        
        for(int contador = 0; contador < ff.length; contador++){
            if(ponteiro.charAt(contador) == '0')
                ff[contador] = new FlipFlopRS(true, false);
            else ff[contador] = new FlipFlopRS(false, true);
        }
    }
    
    public void setRegistrador(String ponteiro){
    
        ff = new FlipFlopRS[8];
        
        if(ponteiro.length() < ff.length){
            for(int c = 0; c < ff.length - ponteiro.length(); c++)
                ponteiro = "0".concat(ponteiro);            
        }
        
        for(int contador = 0; contador < ff.length; contador++){
            if(ponteiro.charAt(contador) == '0')
                ff[contador] = new FlipFlopRS(true, false);
            else ff[contador] = new FlipFlopRS(false, true);
        }
    }
    
    public void mostraBinario(){
    
        System.out.println("bin:");
        for(int c = 0; c < ff.length; c++){
            System.out.println("posicao " + c + ": " + ff[c].isSaida());
        }
            
    }
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);        
        System.out.println("Digite o numero:");
        int entrada = input.nextInt();
        
        try{
            if(entrada < 0 || entrada > 256) throw new Intervalo_Exception("Fora do Intervalo!");
            
            Registrador Res = new Registrador(8);
            Res.mostraBinario();
        
        }catch(Intervalo_Exception IE){
            System.err.println(IE);
        }
    }
}
