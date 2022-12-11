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
package projetoneander;

public class OperacaoAnd{
	
	private boolean a;
	private boolean b;
        
        //construtores
        public OperacaoAnd(){
        
            this(false, false);
        }
	public OperacaoAnd(boolean a){
        
            this(a, true);
        }
	public OperacaoAnd(boolean a, boolean b){
		
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
		
		OperacaoAnd and = new OperacaoAnd(false, false);
		System.out.println(and.getAnd());
		
		and.setAnd(false, true);
		System.out.println(and.getAnd());
		
		and.setAnd(true, true);
		System.out.println(and.getAnd());
	}
}
