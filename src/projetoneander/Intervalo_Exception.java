//https://www.youtube.com/watch?v=CW7DER5TqLM&ab_channel=LoianeGroner

package projetoneander;

public class Intervalo_Exception extends Exception{

    private String msg = "O valor de ";
    
    public Intervalo_Exception() {
    }
    
    public Intervalo_Exception(String nome, int num){
    
        if(num < 0){
        
            msg += nome + " esta a baixo do intervalo";
        }else msg += nome + " esta a cima do intervalo";
    }


    public Intervalo_Exception(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage(){
    
        return msg;
    }
}
