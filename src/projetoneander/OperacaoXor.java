package projetoneander;

public class OperacaoXor{
	
	private boolean a;
	private boolean b;
	
	public OperacaoXor(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
	public boolean getXor(){
		
		PortaNot not = new PortaNot(a);
		PortaAnd and = new PortaAnd(not.getNot(), b);
		
		boolean t = and.getAnd();
		not.setNot(b);
		and.setAnd(not.getNot(), a);
		
		PortaOr or = new PortaOr(t, and.getAnd());
		
		return or.getOr();
	}
	
	public void setXor(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args){
		
		OperacaoXor xor = new OperacaoXor(false, false);
		System.out.println(xor.getXor());
		
		xor.setXor(false, true);
		System.out.println(xor.getXor());
		
		xor.setXor(true, true);
		System.out.println(xor.getXor());
	}
}
