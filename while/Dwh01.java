import java.util.Scanner;

public class Dwh01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero =5;

        do{
            System.out.println(numero);
            numero++;
        }while(numero<=1);
        System.out.println("Fim!");
        sc.close();
    }
}
