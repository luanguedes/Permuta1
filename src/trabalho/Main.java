package trabalho;

import java.util.Scanner;

public class Main {
    
    static String opc2;
    static String opc3;
    static int opc4;
    static int v = 10;
    static String nome[] = new String[v];
    static String cor[] = new String[v];
    static int i;
    static int c = 0;
    static int opc;
    static int x;
    static int qtde[] = new int[v];
    
    public static void main(String[] args) {
        Trabalho trab = Trabalho.getInstance();
        
        do{
        System.out.println("LOJA DE GADGETS");
        System.out.println("");
        System.out.println(trab.getMenus("1"));
        System.out.println(trab.getMenus("2"));
        System.out.println("3 - SAIR");
        System.out.println("");
        
        Scanner op = new Scanner(System.in);
        opc = op.nextInt();
        
        
        switch(opc){
            case 1: 
                c = 0;
                for(i = 0; c != 1; i++){
                System.out.println("");
                System.out.println("Escolha o seu produto:");
                System.out.println(trab.getProdutos("1"));
                System.out.println(trab.getProdutos("2"));
                System.out.println(trab.getProdutos("3"));
                System.out.println("");
                
                
                Scanner op2 = new Scanner(System.in);
                opc2 = op2.nextLine();
                
                nome[i] = opc2;
                System.out.println("");
                System.out.println("Escolha a cor do seu produto:");
                System.out.println(trab.getCor("1"));
                System.out.println(trab.getCor("2"));
                System.out.println(trab.getCor("3")); 
                System.out.println("");
                        
                Scanner op3 = new Scanner(System.in);
                opc3 = op3.nextLine();
                cor[i] = opc3;
                
                System.out.println("");
                System.out.println("Que quantidade desse produto você deseja adquirir?");
                System.out.println("");
                Scanner op4 = new Scanner(System.in);
                opc4 = op4.nextInt();
                qtde[i] = opc4;
                
                System.out.println("");
                System.out.println("Deseja escolher outro produto?");   
                System.out.println("Se sim digite qualquer numero, se não digite: 1");
                System.out.println("");
                Scanner op5 = new Scanner(System.in);
                c = op5.nextInt();
              
                }  break;
                
            
            case 2:
                c = 0;
                System.out.println("");
                System.out.println("PRODUTOS NO SEU CARRINHO:");
                for(i = 0; i < 5; i++){
                if(nome[i] != null){
                System.out.println("");
                System.out.println("Produto: " + trab.getProdutos(nome[i]));
                System.out.println("Cor: " + trab.getCor(cor[i]));
                System.out.println("Quantidade: " + qtde[i]);
                System.out.println("");
                }
                }
                break;
        }

        }while(opc != 3);
        }
}
