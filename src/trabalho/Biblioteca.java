
package trabalho;
import java.util.Random;

public class Biblioteca {
    private static Biblioteca instance;
	private static double total = 0;
        private String metodoPagamento;
       
        
        
        
        public static Biblioteca getInstance() {
        if (Biblioteca.instance == null) {
            instance = new Biblioteca();
        }
        return Biblioteca.instance;
    }
        
	public void imprime() {
		System.out.println("estou imprimindo");
	}
	
	public int retornaInteiro() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
        public double total(){
            return total;
        }
        
	public String cobrar(double total) {
		Biblioteca.total = total;
		return "Valor a ser pago pelo cliente: R$" + total;
	}
	
	public String realizarPagamento(int pagamento) {
		if(Biblioteca.total == 0) {
			return "executar cobrança primeiro";
		}
                else{
                    System.out.println(pagamento);
                    EmissorCreator emissorCreator = new EmissorCreator();
                    Emissor emissor = emissorCreator.pagar(pagamento);
                    boolean retorno = emissor.cobrar();
                    if(emissor instanceof EmissorCartao){
                        if(retorno){
                            System.out.println("Pagamento realizado com sucesso!");
                            metodoPagamento = "Cartão";
                            new Serelizar();
                        }
                        else{
                            System.out.println("Pagamento negado... Transação abortada");
                        }    
                    } else if (emissor instanceof EmissorDinheiro){
                        if(retorno){
                            System.out.println("Pagamento realizado com sucesso!");
                            metodoPagamento = "Dinheiro";
                            new Serelizar();
                        }
                        else{
                            System.out.println("Pagamento negado... Transação abortada");
                        }    
                    } else{
                        metodoPagamento = "Boleto";
                        new Serelizar();
                    }
                }
                return null;
	}
        
        public String metodoPagamento(){
            return metodoPagamento;
        }
        
}