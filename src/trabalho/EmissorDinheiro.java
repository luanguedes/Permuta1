package trabalho;

import java.util.Scanner;

public class EmissorDinheiro implements Emissor{

    @Override
    public boolean cobrar() {
        System.out.println("Qual valor ira pagar?");
        Scanner input = new Scanner(System.in);
        double valor = input.nextDouble();
        if(valor >= Biblioteca.getInstance().total()){
            System.out.println("Seu troco é: " + (valor - Biblioteca.getInstance().total()));
            return true;
        }
        else{
            System.out.println("Valor inserido é insuficiente");
            return false;
        }
    }
    
}
