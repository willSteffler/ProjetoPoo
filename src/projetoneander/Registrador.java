/*

 */
package projetoneander;

public class Registrador {
    
    private FlipFlop ff[];
    
    public Registrador(String ponteiro){
    
        ff = new FlipFlop[8];
        
        if(ponteiro.length() < ff.length){
            for(int c = 0; c < ff.length - ponteiro.length(); c++)
                ponteiro = "0".concat(ponteiro);       
        }
        
        for(int contador = 0; contador < ff.length; contador++){
            if(ponteiro.charAt(contador) == '0')
                ff[contador] = new FlipFlop(true, false);
            else ff[contador] = new FlipFlop(false, true);
        }
    }
    
    public void setRegistrador(String ponteiro){
    
        ff = new FlipFlop[8];
        
        if(ponteiro.length() < ff.length){
            for(int c = 0; c < ff.length - ponteiro.length(); c++)
                ponteiro = "0".concat(ponteiro);            
        }
        
        for(int contador = 0; contador < ff.length; contador++){
            if(ponteiro.charAt(contador) == '0')
                ff[contador] = new FlipFlop(true, false);
            else ff[contador] = new FlipFlop(false, true);
        }
    }
}
