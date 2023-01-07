
package projetoneander;

public class PortaNand {
    
    private PortaAnd and = new PortaAnd();
    private PortaAnd and2 = new PortaAnd();
    private PortaNot not = new PortaNot();
    
    public PortaNand(){}
    
    public PortaNand(boolean a, boolean b){
    
        this(a, b, true);
    }

    public PortaNand(boolean a, boolean b, boolean c) {
        
        and2.setAnd(a, b);
        and.setAnd(and2.getAnd(), c);
    }
    
    public boolean getNand(){
    
        not.setNot(and.getAnd());
        return not.getNot();
    }

    public void setNand(boolean a, boolean b) {
        
        and.setAnd(a, b);
    }
    
    public void setNand(boolean a){
    
        setNand(a, true);
    }
    
    public static void main(String[] args){
    
        PortaNand nand = new PortaNand(false, false, false);
        System.out.println("nand: " + nand.getNand());
    }
}
