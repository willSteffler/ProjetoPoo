
package projetoneander;

public class Multiplex {
    
    private PortaAnd and[];
    private PortaOr or = new PortaOr();

    public Multiplex(boolean a, boolean b, boolean c) {
        
        and = new PortaAnd[2];
        PortaNot not = new PortaNot(c);
        
        and[0] = new PortaAnd(a, not.getNot());
        and[1] = new PortaAnd(b, c);
        
        or.setOr(and[0].getAnd(), and[1].getAnd());
    }
    
    public boolean getMux(){
    
        return or.getOr();
    }
    
    public void setMux(boolean a, boolean b, boolean c){
    
        PortaNot not = new PortaNot(c);
        
        and[0].setAnd(a, not.getNot());
        and[1].setAnd(b, c);
        
        or.setOr(and[0].getAnd(), and[1].getAnd());
    }
    
    public static void main(String[] args){
    
        Multiplex mux = new Multiplex(false, true, true);
        System.out.println("mux: " + mux.getMux());
    }
}
