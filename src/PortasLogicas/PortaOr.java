/*
Operacao Or:
    Possui dois atributos privados 'a' e 'b' do tipo boolean
    Possui tres construtores:
        Sendo que um nao recebe argumentos e passa dois valores 'false' para o construtor principal
        O segundo recebe um argumento que passa junto com um valor 'false' para o construtor principal
        O terceiro recebe dois argumentos.

    Possui um metodo getOr que retornar o valor 'a || b'
    Possui um metodo setOr com dois argumentos.
*/

package PortasLogicas;

public class PortaOr{
	
	private boolean a;
	private boolean b;
        
        //construtores
        public PortaOr(){
        
            this(false, false);
        }
        
        public PortaOr(boolean a){
        
            this(a, false);
        }
	
	public PortaOr(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
        //metodos getter e setter
	public boolean getOr(){
		
		return a | b;
	}
	
	public void setOr(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args){
		
		PortaOr or = new PortaOr(false, false);
		System.out.println(or.getOr());
		
		or.setOr(false, true);
		System.out.println(or.getOr());
	}
}
