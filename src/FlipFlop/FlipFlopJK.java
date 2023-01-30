/*
 * Evolucao do FF RS sincrono(tem clock)
 * Eliminar com a condicao proibida
 *                  Tabela:
 *  CLK     J       K       Q       ¬Q      Estado
 *   0      X       X       Qa      ¬Qa      Mem
 *   1      0       0       Qa      ¬Qa      Mem
 *   1      0       1       0       1        Reset
 *   1      1       0       1       0        Set
 *   1      1       1       ¬Qa     Qa       Troca
 */
package FlipFlop;

/**
 *
 * @author William
 */
public class FlipFlopJK extends FlipFlop{
    
    private boolean J;
    private boolean K;
    private boolean CLK;

    public FlipFlopJK(boolean J, boolean K, boolean CLK) {
        this.J = J;
        this.K = K;
        this.CLK = CLK;
    }
    
    @Override
    public boolean estadoFlipFlop(){        
        return this.saidaQ;
    }
    
    public boolean estadoFlipFlop(boolean J, boolean K, boolean CLK){        
        if(CLK == true){
            if(J == false && K == true){
                this.saidaQ = false;
                this.saidaQN = true;
            }else if(J == true && K == false){
                this.saidaQ = true;
                this.saidaQN = false;
            }else if(J == true && K == true){
                boolean temp = saidaQ;
                this.saidaQ = saidaQN;
                this.saidaQN = temp;
            }
        }
        
        this.J = J;
        this.K = K;
        this.CLK = CLK;
        
        return saidaQ;
    }
    
    public static void main(String[] args){
        FlipFlopJK jk = new FlipFlopJK(false, true, true);
        System.out.println("retorno = " + jk.estadoFlipFlop());
        
        System.out.println("Novo estado = " + jk.estadoFlipFlop(true, false, true));
    }
}
