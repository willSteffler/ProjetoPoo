/*
Operacao And:
    Possui dois atributos privados do tipo boolean

    Possui tres construtores:
        O primeiro nao tem argumentos e envia para o construtor principal dois valores 'false'
        O segundo recebe um argumento e passa para o construtor principal junto com um valor 'false'
        O terceiro recebe dois argumentos que definem os atributos da classe

    Possui um metodo getAnd que retorna 'a & b'.
    Possui um metodo setAnd que redefine os valores dos atributos.
*/
package PortasLogicas;

public class PortaAnd{
	
	private boolean a;
	private boolean b;
        
        //construtores
        public PortaAnd(){
        
            this(false, false);
        }
	public PortaAnd(boolean a){
        
            this(a, true);
        }
	public PortaAnd(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}
	
        //metodos getter e setter
	public boolean getAnd(){
		
		return a & b;
	}
	
	public void setAnd(boolean a, boolean b){
		
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args){
		
		PortaAnd and = new PortaAnd(false, false);
		System.out.println(and.getAnd());
		
		and.setAnd(false, true);
		System.out.println(and.getAnd());
		
		and.setAnd(true, true);
		System.out.println(and.getAnd());
	}
}
