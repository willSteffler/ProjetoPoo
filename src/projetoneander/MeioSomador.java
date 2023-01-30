package projetoneander;

import PortasLogicas.PortaXor;
import PortasLogicas.PortaAnd;

public class MeioSomador{
	
	private boolean b;
	private boolean a;
	
	public MeioSomador(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
	public boolean soma(){
		
		PortaXor xor = new PortaXor(a, b);
		
		return xor.getXor();
	}
	
	public boolean carry(){
		
		PortaAnd and  = new PortaAnd(a, b);
		
		return and.getAnd();
	}
	
	public void setMeioSomador(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args){
		
		MeioSomador ms = new MeioSomador(false, false);
		System.out.println("soma= " + ms.soma() + "carry= " + ms.carry());
		
		ms.setMeioSomador(false, true);
		System.out.println("soma= " + ms.soma() + "carry= " + ms.carry());
		
		ms.setMeioSomador(true, true);
		System.out.println("soma= " + ms.soma() + "carry= " + ms.carry());
	}
}
