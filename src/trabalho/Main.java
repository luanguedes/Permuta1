package trabalho;

import java.util.Scanner;
import pojo.Produto;

public class Main {
    
    
    
    static int opc4;
    static int v = 10;
    static String nome;
    static String cor[] = new String[v];
    static int i;
    static int c = 0;
    static int opc;
    static int x;
    static int qtde[] = new int[v];
    
    public static void main(String[] args) {
         Produto produto = new Produto();
        Trabalho trab = Trabalho.getInstance();
        Scanner op = new Scanner(System.in);
        
        do{
        System.out.println("");
        System.out.println("LOJA DE GADGETS");
        System.out.println("SEJA BEM VINDO");
        System.out.println("");
        System.out.println("1 - COMPRAR UM PRODUTO");
        System.out.println("2 - CARRINHO");
        System.out.println("3 - REMOVER PRODUTO DO CARRINHO");
        System.out.println("4 - VERIFICAR VALOR");
        System.out.println("5 - FINALIZAR PEDIDO");
        System.out.println("6 - SAIR");
        System.out.println("");
        
       
        opc = op.nextInt();
        
        
        
        switch(opc){
            case 1: 
               
                System.out.println("");
                System.out.println("Digite o nome do produto que deseja:");
                Scanner input = new Scanner(System.in);
                produto.setNome(input.nextLine());
                input = new Scanner(System.in);
                System.out.println("Que quantidade desse produto você deseja adquirir?");
                produto.setQtde(input.nextInt());
                
                
                
               
                Carrinho.getInstance().addProduto(produto);
                 break;
                
            
            case 2:
                
                System.out.println("");
                System.out.println("PRODUTOS NO SEU CARRINHO:");
                Carrinho.getInstance().toString();    
                System.out.println("Id: "+produto.getId());
                System.out.println("Nome: "+produto.getNome());
                System.out.println("Quantidade: "+produto.getQtde());
                System.out.println("Preço: "+produto.getPreco());
                
                
             
                
                break;
            case 3:
                System.out.println("EXCLUSÃO DE PRODUTOS DO CARRINHO:");
                System.out.println("Digite o id do produto que deseja excluir do carrinho:");
                input = new Scanner(System.in);
                Carrinho.getInstance().removeProd(input.nextInt());
                break;
                
            case 4:
                
                System.out.println(Facade.getInstance().cobrar(produto.getPreco()));
                break;
            
            case 5:
                System.out.println("Qual valor irá usar para pagar?");
                input = new Scanner(System.in);
                System.out.println(Facade.getInstance().realizarPagamento(input.nextDouble()));
                input = new Scanner(System.in);
                
            default:
                System.out.println("Escolha uma opção válida...");
                break;
        }
        }while(opc != 6);
        }

    @Override
    public String toString() {
       
        return null;
    }
    

    
}
