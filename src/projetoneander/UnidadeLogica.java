package projetoneander;

import java.util.Scanner;

public class UnidadeLogica {
    
    public static void main(String[] args){
    
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Operação not");
        System.out.println("2 - Operação or");
        System.out.println("3 - Operação and");
        System.out.println("4 - Operção soma");
        int op = entrada.nextByte();
        
        switch(op){
        
            case 1 -> {
                try{
                    
                    System.out.print("Digite um numero: ");
                    int num = entrada.nextInt();
                    
                    if(num < 0 || num >= 256) throw new Intervalo_Exception("num", num);
                    
                    NotOitoBits nob = new NotOitoBits(num);
                    nob.mostraBinario();
                }catch(Intervalo_Exception e){
                
                    System.out.println(e.getMessage());
                }
            }
            
            case 2 -> {
                try{
                
                    System.out.print("Digite o primerio numero: ");
                    int num = entrada.nextInt();
                    
                    if(num < 0 || num >= 256) throw new Intervalo_Exception("num", num);
                    
                    System.out.print("Digite o segundo numero: ");
                    int num2 = entrada.nextInt();
                    
                    if(num2 < 0 || num2 >= 256) throw new Intervalo_Exception("num2", num2);
                    
                    OrOitoBits oob = new OrOitoBits(num, num2);
                    oob.mostraBinario();
                }catch(Intervalo_Exception e){
            
                    System.out.println(e.getMessage());
                }
            }
            
            case 3 -> {
            
                try{
                
                    System.out.print("Digite o primerio numero: ");
                    int num = entrada.nextInt();
                    
                    if(num < 0 || num >= 256) throw new Intervalo_Exception("num", num);
                    
                    System.out.print("Digite o segundo numero: ");
                    int num2 = entrada.nextInt();
                    
                    if(num2 < 0 || num2 >= 256) throw new Intervalo_Exception("num2", num2);
                    
                    AndOitoBits aob = new AndOitoBits(num, num2);
                    aob.mostraBinario();
                }catch(Intervalo_Exception e){
            
                    System.out.println(e.getMessage());
                }               
            }
            
            case 4 -> {
            
                try{
                
                    System.out.print("Digite o primerio numero: ");
                    int num = entrada.nextInt();
                    
                    if(num < 0 || num >= 256) throw new Intervalo_Exception("num", num);
                    
                    System.out.print("Digite o segundo numero: ");
                    int num2 = entrada.nextInt();
                    
                    if(num2 < 0 || num2 >= 256) throw new Intervalo_Exception("num2", num2);
                    
                    SomadorOitoBits sob = new SomadorOitoBits(num, num2);
                    sob.mostraBinario();
                }catch(Intervalo_Exception e){
            
                    System.out.println(e.getMessage());
                }
            }
        }
    }    
}
