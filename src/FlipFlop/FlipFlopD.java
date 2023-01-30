/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlipFlop;

/**
 *
 * @author William
 */
public class FlipFlopD extends FlipFlop{
    
    private boolean D;
    private boolean CLK;
    
    public FlipFlopD(){
        this(false);
    }
    
    public FlipFlopD(boolean D){
        this.D = saidaQ = D;
        saidaQN = !D;
    }

    public FlipFlopD(boolean D, boolean CLK) {        
        if(this.CLK == false && CLK == true){
            saidaQ = D;
            saidaQN = !D;
        }

        this.CLK = CLK;
    }
    
    @Override
    public boolean estadoFlipFlop(){
        return saidaQ;
    }
    
    public boolean estadoFlipFlop(boolean D, boolean CLK){
        if(this.CLK == false && CLK == true){
            saidaQ = D;
            saidaQN = !D;
        }
        this.CLK = CLK;
        return saidaQ;
    }
    
    public boolean estadoFlipFlop(boolean D){
        this.D = saidaQ = D;
        saidaQN = !D;
        
        return saidaQ;
    }
    
    static public void main(String[] args){
        FlipFlopD FFD = new FlipFlopD(false, true);
        System.out.println("saida: " + FFD.estadoFlipFlop());
        
        System.out.println("saida: " + FFD.estadoFlipFlop(true, false));
        System.out.println("saida: " + FFD.estadoFlipFlop(true, true));
    }
}
