import java.util.Scanner;

public class atvCond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um Número: ");
        int numero = sc.nextInt();

        if (numero>1) {
            System.out.println("Número Positivo.");
        }else if (numero<0){
            System.out.println("Número Negativo.");
        }else if (numero == 0) {
            System.out.println("Número Nulo.");
        }
        
        
        
        
        sc.close();

    }
}
