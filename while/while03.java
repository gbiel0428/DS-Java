import java.util.Scanner;

public class while03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um Número: ");
        int limite = sc.nextInt();

        int numero =1;
        while (numero<=limite) {
            System.out.println(numero);
            numero ++;
        }



        sc.close();
    }
}
