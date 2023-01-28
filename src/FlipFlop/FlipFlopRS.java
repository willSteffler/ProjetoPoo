/*
    https://www.youtube.com/watch?v=FErXuyNpdQQ
 */
package FlipFlop;

import projetoneander.PortaAnd;
import projetoneander.PortaNand;
import projetoneander.PortaNot;

public class FlipFlopRS {
    
    private PortaNand nand[] = new PortaNand[2];
    private PortaAnd and[] = new PortaAnd[2];
    private PortaNot not[] = new PortaNot[2];
    
    private boolean saida;
    private boolean saida_negada = !saida;

    public FlipFlopRS(boolean r, boolean s) {
        
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
        
        not[0] = new PortaNot(r);
        
        nand[0] = new PortaNand(not[0].getNot(), s);
        saida_negada = nand[0].getNand();
        
        saida = s;
    }

    public void alteraEstado(boolean r, boolean s){
    
        not[0].setNot(r);
        not[1] = new PortaNot(s);
        
        nand[1] = new PortaNand(not[1].getNot(), saida_negada);

        saida = nand[1].getNand();
        
        nand[0].setNand(not[0].getNot(), saida);

        saida_negada = nand[0].getNand();
    }
    
    public boolean isSaida() {
        return saida;
    }

    public boolean isSaida_negada() {
        return saida_negada;
    }
    
    
    public static void main(String[] args){
    
        FlipFlopRS ff = new FlipFlopRS(true, false);
        System.out.println("Psaida: " + ff.isSaida() + " Pneg: " +
                ff.isSaida_negada());   //Psaida: false Pneg: true
        
        ff.alteraEstado(false, false);
        System.out.println("saida: " + ff.isSaida() + " neg: " + 
                ff.isSaida_negada());   //saida: false neg: true
        
        ff.alteraEstado(true, true);
        System.out.println("saida: " + ff.isSaida() + " neg: " + 
                ff.isSaida_negada());   //saida: true neg: true
        
        ff.alteraEstado(false, false);
        System.out.println("saida: " + ff.isSaida() + " neg: " + 
                ff.isSaida_negada());   //saida: true neg: true
        
        ff.alteraEstado(false, true);
        System.out.println("saida: " + ff.isSaida() + " neg: " +
                ff.isSaida_negada());   //saida: true neg: false
        
        ff.alteraEstado(false, false);
        System.out.println("saida: " + ff.isSaida() + " neg: " + 
                ff.isSaida_negada());   //saida: true neg: false
    }
}
