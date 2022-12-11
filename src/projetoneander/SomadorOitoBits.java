package projetoneander;

public class SomadorOitoBits {
    
    private SomadorCompleto sc[];
    
    public SomadorOitoBits(int num, int num2){
    
        this.sc = new SomadorCompleto[8];
        
        String bin = Integer.toBinaryString(num);
        String bin2 = Integer.toBinaryString(num2);
        
        for(int contador = 0; contador < sc.length; contador++){
        if(contador < sc.length - bin.length() && contador < sc.length - bin2.length()){
        
            sc[contador] = new SomadorCompleto();
        }//...
            
        }
    }
}
