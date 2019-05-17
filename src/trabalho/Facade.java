/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.util.Random;

public class Facade {
    private static Facade instance;
	private static double total = 0;
        
        
        
        public static Facade getInstance() {
        if (Facade.instance == null) {
            instance = new Facade();
        }
        return Facade.instance;
    }
        
	public void imprime() {
		System.out.println("estou imprimindo");
	}
	
	public int retornaInteiro() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
	public String cobrar(double total) {
		Facade.total = total;
		return "Valor a ser pago pelo cliente: R$" + total;
	}
	
	public String realizarPagamento(double valorPago) {
		if(Facade.total == 0) {
			return "executar cobrança primeiro";
		}
		else if(Facade.total <= valorPago) {
			return "Troco: R$" + (valorPago - Facade.total);
		}
		else {
			return "O valor pago está incorreto. O Valor total é R$:"+ Facade.total + 
					" e o valor pago é R$:" + valorPago;
		}
	}
}