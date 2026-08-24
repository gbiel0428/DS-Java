import java.util.Scanner;

public class ATV5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe O Número: ");
        int numero = sc.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(numero+ " x " +i+ " = " +(numero*i));
        }


        sc.close();
    }
}
