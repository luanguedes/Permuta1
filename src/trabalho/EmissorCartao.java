package trabalho;

import java.util.Random;
import java.util.Scanner;

public class EmissorCartao implements Emissor{

    @Override
    public boolean cobrar() {
        System.out.println("Entre com o numero do seu cartão: ");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        System.out.println("Entre com o código de segurança do seu cartão: ");
        input = new Scanner(System.in);
        input.nextLine();
        System.out.println("");
        Random valor = new Random();
        int v = valor.nextInt(10);
        if(v == 3 || v == 6){
            return false;
        }
        else{
            return true;
        }
    }
    
}
