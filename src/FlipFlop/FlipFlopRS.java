/*
    https://www.youtube.com/watch?v=FErXuyNpdQQ
 */
package FlipFlop;

public class FlipFlopRS extends FlipFlop{
    
    private boolean R;
    private boolean S;
        
        /*
            r   s  !r  !s   q  !q
            0   0   1   1   0   1
            0   1   1   0   1   0
            1   0   0   1   0   1
            1   1   0   0   1   1 
        
            *q e !q = 0
            !r|q    !(!r|q)     !s|!q   !(!s|!q)
            1|0=0       1        1|1=1     0
              =         =        0|1=0     1
            0|0=0       1        1|1=1     0
                =       =        0|0=0     1
        
            q = !(!s|!q)
            !q = !(!r|q)
        */
        
        
        //q == s
        //!q == !(!r|s)
        
    
    public FlipFlopRS(boolean R, boolean S){
        
        this.R = R;
        this.S = S;
        
        if(R == false && S == true){
            saidaQ = true;
            saidaQN = false;
        }else if(R == true && S == false){
            saidaQ = false;
            saidaQN = true;
        }else if(R == true && S == true){
            saidaQ = true;
            saidaQN = true;
        }
    }
    
    @Override
    public boolean estadoFlipFlop(){     
        return saidaQ;
    }
    
    public boolean estadoFlipFlop(boolean R, boolean S){
        if(R == false && S == true){
            saidaQ = true;
            saidaQN = false;
        }else if(R == true && S == false){
            saidaQ = false;
            saidaQN = true;
        }else if(R == true && S == true){
            saidaQ = true;
            saidaQN = true;
        }
        
        return saidaQ;
    }
    
    
    public static void main(String[] args){
    
        FlipFlopRS RS = new FlipFlopRS(true, false);
        System.out.println("Saida Q: " + RS.isSaidaQ() + " saida QN: " +
                RS.isSaidaQN());   //Psaida: false Pneg: true
        
        System.out.println("Saida Q: " + RS.estadoFlipFlop(false, false) + 
                " saida QN: " + RS.isSaidaQN());
        
        System.out.println("Saida Q:" + RS.estadoFlipFlop(true, true) + 
                " Saida QN: " + RS.isSaidaQN());
        
        System.out.println("Saida Q:" + RS.estadoFlipFlop(false, true) + 
                " Saida QN: " + RS.isSaidaQN());

    }
}
