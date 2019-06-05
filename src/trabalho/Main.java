package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import pojo.Produto;

public class Main implements Observer{

    static int opc4;
    static int v = 10;
    static String nome;
    static String cor[] = new String[v];
    static int i;
    static int c = 0;
    static int opc;
    static int x;
    static int qtde[] = new int[v];
    public static List<Produto> prod = new ArrayList();
    
   

    public static void main(String[] args) {
        new Desserelizar();
        Carrinho carrinho = Carrinho.getInstance();
        carrinho.addObserver(new Main());
        Produto produto = new Produto();
        Trabalho trab = Trabalho.getInstance();
        Scanner op = new Scanner(System.in);
         int tamanho = prod.size();
       

        do {
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

            switch (opc) {
                case 1:
                    
                    System.out.println("");
                    for (int z = 0; z < tamanho; z++) {
                        System.out.println(prod.get(z).getId() + " - " + prod.get(z).getNome());
                    }
                    System.out.println("");
                    System.out.println("Digite o codigo do produto que deseja:");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    Produto pro = pesquisar(id);
                    Carrinho.getInstance().addProduto(pro);
                   
                   
                    break;

                case 2:

                    System.out.println("");
                    System.out.println("PRODUTOS NO SEU CARRINHO:");
                    Carrinho.getInstance().lerCarrinho();
                    System.out.println("");                    
                    break;
                    
                case 3:
                    System.out.println("EXCLUSÃO DE PRODUTOS DO CARRINHO:");
                    System.out.println("Digite o id do produto que deseja excluir do carrinho:");
                    input = new Scanner(System.in);
                    Carrinho.getInstance().removeProd(input.nextInt());
                    
                    break;
                    
                case 4:
                    
                    System.out.println(Facade.getInstance().cobrar(Carrinho.getInstance().gerarTotal()));
                    break;
                    
                case 5:
                    System.out.println("Escolha o método de pagamento: ");
                    System.out.println("");
                    System.out.println("1 - BOLETO");
                    System.out.println("2 - DINHEIRO");
                    System.out.println("3 - CARTÃO");
                    System.out.println("");
                    input = new Scanner(System.in);
                    Facade.getInstance().realizarPagamento(input.nextInt());
                   break;

                default:
                    System.out.println("Escolha uma opção válida...");
                    break;
            }
        } while (opc != 6);
    }

   
    
    public static Produto pesquisar(int id){
        for(int c = 0; c < prod.size(); c++){
            if(id == prod.get(c).getId()){
                return prod.get(c);
            }
        }
        return null;
    }
        
    @Override
    public String toString() {
        return null;
    }
    
    @Override
    public void update(Observable o, Object o1) {
           Carrinho.getInstance().lerCarrinho();
    }

}
