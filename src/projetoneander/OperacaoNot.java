/*
Operacao Not:
    A classe possui uma atributo privada do tipo booleana de nome 'a'

    Possui dois construtores:
        Sendo que um nao recebe argumento e guarda em 'a' o valor 'false'
        O segundo recebe um argumento e guarda em 'a' sempre o valor boolean

    Possui um metodo getNot que retorna sempre o valor inverso
    Possui um metodo setNot para o atributo 'a'
*/

package projetoneander;

public class OperacaoNot{
	
	private boolean a;
	
        //construtores
        public OperacaoNot(){
        
            this.a = false;
        }
        
	public OperacaoNot(boolean a){
		
		this.a = a;
	}
	
        //metodos getter e setter
	public boolean getNot(){
		
		return a != true;
	}
	
	public void setNot(boolean a){
		
		this.a = a;
	}
	
	public static void main(String[] args){
		
		OperacaoNot not = new OperacaoNot(true);
		System.out.println(not.getNot());
		
		not.setNot(false);
		System.out.println(not.getNot());
	}
}
