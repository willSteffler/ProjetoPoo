/*
Duas portas AND's oito bits e uma porta OR oito bits
um sinal de controle

*/
package projetoneander;

public class MuxOitoBits {
    
    private Multiplex mux[];
    
    public MuxOitoBits(int num, int num2, boolean c) throws Intervalo_Exception{
    
        mux = new Multiplex[8];
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);
        
        int tam = mux.length - bin.length();
        if(bin.length() < mux.length){
            for(int i = 0; i < tam; i++){
                
                bin = "0".concat(bin);
            }            
        }
        
        tam = mux.length - bin2.length();
        if(bin2.length() < mux.length){
            for(int i = 0; i < tam; i++){
                
                bin2 = "0".concat(bin2);
            }
        }
        
        for(int i = 0; i < mux.length; i++)
            
            mux[i] = new Multiplex((bin.charAt(i) == '1'),
                    (bin2.charAt(1) == '1'), c);
        
    }
}
