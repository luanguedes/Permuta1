package trabalho;

public class EmissorCreator {
    public static final int boleto = 1;
    public static final int dinheiro = 2;
    public static final int cartao = 3;
    private static EmissorCreator instance;
    
    public static EmissorCreator getInstance() {
        if (EmissorCreator.instance == null) {
            instance = new EmissorCreator();
        }
        return EmissorCreator.instance;
    }
    
    public Emissor pagar(int tipoDePagamento){
        
        switch(tipoDePagamento){
            case boleto : 
                return new EmissorBoleto();
            case dinheiro :
                return new EmissorDinheiro();
            case cartao :
                return new EmissorCartao();
            default: 
                throw new IllegalArgumentException("Tipo de pagamento não suportado");
        }
        

    }
}
