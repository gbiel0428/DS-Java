package Exeções;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Informe um número: ");
            int numero = sc.nextInt();
            System.out.println("Número informado: "+numero);
        }catch(InputMismatchException e){
            System.out.println("Erro: Entrada inválida. Por favor, informe um número inteiro.");
        }finally{
            System.out.println("Encerrado.");
        }
        sc.close();
    }
}
