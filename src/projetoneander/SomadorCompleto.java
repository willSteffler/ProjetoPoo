package projetoneander;

import PortasLogicas.PortaOr;

public class SomadorCompleto{
	
	private boolean a;
	private boolean b;
	private boolean c;
	private MeioSomador[] ms;
	
	//construtores
	public SomadorCompleto(){
		
		this(false, false, false);
	}
	
        public SomadorCompleto(boolean a){
        
            this(a, false, false);
        }
        
	public SomadorCompleto(boolean a, boolean b){
		
		this(a, b, false);
	}
	
	public SomadorCompleto(boolean a, boolean b, boolean c){
		
		this.a = a;
		this.b = b;
		this.c = c;
		
		ms = new MeioSomador[2];
	
		ms[0] = new MeioSomador(a, b);
		ms[1] = new MeioSomador(ms[0].soma(), c);
	}
	
	public boolean soma(){
		
		return ms[1].soma();
	}
	
	public boolean carry(){
		
		PortaOr or = new PortaOr(ms[0].carry(), ms[1].carry());
		
		return or.getOr();
	}
	
	public void setSomadorCompleto(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
		
		ms[0].setMeioSomador(a, b);
		ms[1].setMeioSomador(ms[0].soma(), c);
	}
        
        public void setSomadorCompleto(boolean a, boolean b, boolean c){
        
            this.a = a;
            this.b = b;
            
            ms[0].setMeioSomador(a, b);
            ms[1].setMeioSomador(ms[0].soma(), c);
        }
	
	public void setCarryIn(boolean c){
		
		this. c = c;
		
		ms[0] = new MeioSomador(a, b);
		ms[1] = new MeioSomador(ms[0].soma(), c);
	}
	
	public static void main(String[] args){
		
		SomadorCompleto sc = new SomadorCompleto();	//soma 0 + 0
		System.out.println("Soma= " + sc.soma() + " Carry= " + sc.carry());
		
		sc.setSomadorCompleto(false, true);	//soma 0 + 1
		System.out.println("Soma= " + sc.soma() + " Carry= " + sc.carry());
		
		sc.setSomadorCompleto(true, true);	//soma 1 + 1
		System.out.println("Soma= " + sc.soma() + " Carry= " + sc.carry());
                
                sc.setSomadorCompleto(true, true, true);	//soma 1 + 1
		System.out.println("Soma= " + sc.soma() + " Carry= " + sc.carry());
	}
}
