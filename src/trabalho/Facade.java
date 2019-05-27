package trabalho;

public class Facade {
   
    private static Facade instance;
    
    public static Facade getInstance() {
        if (Facade.instance == null) {
            instance = new Facade();
        }
        return Facade.instance;
    }
        public String cobrar(double total){
            Biblioteca.getInstance().cobrar(total);
            return "";
        }
        
        public String realizarPagamento(double valorPago){
            Biblioteca.getInstance().realizarPagamento(valorPago);
            return "";
        }
}

