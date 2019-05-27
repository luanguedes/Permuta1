package trabalho;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import pojo.Produto;

public class Carrinho extends Observable{
    
    private static Carrinho instance;
    private ArrayList<Produto> listCarrinho = new ArrayList<Produto>();
    
    private Carrinho(){
      
    }
    public void mudaStatus(){
        setChanged();
        notifyObservers();
    }
    
    
     public static Carrinho getInstance() {
        if (Carrinho.instance == null) {
            instance = new Carrinho();
        }
        return Carrinho.instance;
    }
    
     public void lerCarrinho(){
         System.out.println("");
         System.out.println("SEU CARRINHO:");
         System.out.println("");
         for(int x = 0; x < listCarrinho.size(); x++){   
             System.out.println(listCarrinho.get(x).getId() + " - " + listCarrinho.get(x).getNome());
         }
     }
     
     public void addProduto (Produto produto){
         listCarrinho.add(produto);
         mudaStatus();
     }
     
     public String removeProd(int id){
         for(int i = 0; i < listCarrinho.size(); i++){
             if(listCarrinho.get(i).getId() == id){
                 listCarrinho.remove(i);
                 mudaStatus();
                 return "Removido com sucesso!";
             }
             
         }
         
         return "Produto não estava no seu carrinho...";
     }

    
}
