package trabalho;

import java.util.HashMap;

public class Trabalho {

    private static Trabalho instance;

  
    private HashMap<String, String> produtos = new HashMap<String, String>();
    private HashMap<String, String> cor = new HashMap<String, String>();

    private Trabalho() {

        produtos.put("1", "1 - XIAOMI MI BAND");
        produtos.put("2", "2 - XIAOMI MI BAND 2");
        produtos.put("3", "3 - XIAOMI MI BAND 3");
        cor.put("1", "1 - PRETO");
        cor.put("2", "2 - AZUL");
        cor.put("3", "3 - VERMELHO");
    }

    public static Trabalho getInstance() {
        if (Trabalho.instance == null) {
            Trabalho.instance = new Trabalho();
        }
        return Trabalho.instance;
    }

   
    public String getProdutos(String nomeDoProduto) {
        return this.produtos.get(nomeDoProduto);
    }

    public void setProdutos(String nomeDoProduto, String valor) {
         this.produtos.replace(nomeDoProduto, valor);
    }

    public String getCor(String nomeDoProduto) {
        return this.cor.get(nomeDoProduto);
    }

    public void setCor(String nomeDaCor, String valor) {
         this.cor.replace(nomeDaCor, valor);
    }

  

    

}
