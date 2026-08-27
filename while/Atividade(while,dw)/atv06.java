import java.util.Scanner;

public class atv06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 1;

        while (num>0) {
            System.out.println("Digite um Número: ");
            num = sc.nextInt();
        }
        System.out.println("Voçê digitou um Número Negativo.");
        sc.close();
    }
}
