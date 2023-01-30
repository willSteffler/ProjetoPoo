/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoneander;

import FlipFlop.FlipFlopD;

/**
 *
 * @author William
 */
public class Contador {
    private FlipFlopD[] FFD;
    //inicializa sempre com zero, exceto qndo for um desvio
    
    public Contador(){
        FFD = new FlipFlopD[4];
        
        for(int c = 0; c < FFD.length; c++){
            FFD[c] = new FlipFlopD();
        }
    }
    public Contador(boolean entrada) {
        FFD = new FlipFlopD[4];
        
        for(int c = 0; c < FFD.length; c++){
            FFD[c] = new FlipFlopD(entrada);
        }
    }
    
    public void converte(int valor){
        
        String bin = Integer.toBinaryString(valor);
        
        int tam = bin.length() - FFD.length;
        while(bin.length() < FFD.length){
            bin = "0".concat(bin);
        }
        
        for(int c = 0 ; c < bin.length(); c++){
            if(bin.charAt(c) == '0')
                FFD[c].estadoFlipFlop(false);
            else
                FFD[c].estadoFlipFlop(true);
        }
    }

    //acrescenta um no array:
    // 0000 +1 = 0001     0001 +1 = 0010
    public void acrescenta(){
        for(int c = FFD.length - 1; c >= 0; c--){
            if(FFD[c].isSaidaQ() == false)
                FFD[c].estadoFlipFlop(true);
        }
    }

    public String retornaBinario(){
        String bin = "";
        
        for (FlipFlopD FFD1 : FFD) {
            if (FFD1.isSaidaQ() == false) {
                bin += "0";
            } else {
                bin += "1";
            }
        }
        
        return bin;
    }
    
    static public void main(String[] args){
        Contador Cont = new Contador(false);
        
        System.out.println(Cont.retornaBinario());
    }
}
