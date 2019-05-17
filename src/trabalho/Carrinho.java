package trabalho;

import java.util.ArrayList;
import java.util.Random;
import pojo.Produto;

public class Carrinho {
    
    private static Carrinho instance;
    private ArrayList<Produto> listCarrinho = new ArrayList<Produto>();
    
    private Carrinho(){
        
    }
    
     public static Carrinho getInstance() {
        if (Carrinho.instance == null) {
            instance = new Carrinho();
        }
        return Carrinho.instance;
    }
     
     public void addProduto (Produto produto){
         Random r = new Random();
         produto.setId(r.nextInt());
         produto.setPreco(50.00);
         listCarrinho.add(produto);
     }
     
     public String removeProd(int id){
         for(int i = 0; i < listCarrinho.size(); i++){
             if(listCarrinho.get(i).getId() == id){
                 listCarrinho.remove(i);
                 return "Removido com sucesso!";
             }
         }
         
         return "Produto não estava no seu carrinho...";
     }
}
