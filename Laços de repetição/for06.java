import java.util.Scanner;

public class for06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o Número: ");
        int numero =sc.nextInt();
        System.out.printf("%n");

        for(int i=1;i<=10;i++){
            System.out.println(numero+ " x " +i+ " = " +(numero*i));
        }


        sc.close();
    }
}
