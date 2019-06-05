package trabalho;

import java.util.Random;

public class EmissorBoleto implements Emissor{

    @Override
    public boolean cobrar() {
        System.out.println("O seu boleto para pagamento foi gerado");
        System.out.println("Este é o código de barras do boleto: " + gerarBoleto());
        System.out.println("A transação apenas será liberada após o pagamento do boleto");
        System.out.println("Se o pagamento não for realizado em até 3 dias úteis a compra será cancelada!");
        return true;
    }
    
    public String gerarBoleto(){
        String retorno = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            retorno += ""+ random.nextInt(10);
        }
        return retorno;
    }
    
}
