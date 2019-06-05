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
            return Biblioteca.getInstance().cobrar(total);
        }
        
        public String realizarPagamento(int pagamento){
            Biblioteca.getInstance().realizarPagamento(pagamento);
            return "";
        }
}

