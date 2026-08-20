import java.util.Scanner;

public class atvCond02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um Número: ");
        int numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Número par.");
        }else {
            System.out.println("Número impar.");
        }


        sc.close();
    }
}
