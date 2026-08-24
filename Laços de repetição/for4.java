import java.util.Scanner;

public class for4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=3;i++){
            System.out.println("Informe o "+i+"º Número: ");
            int numero = sc.nextInt();
            System.out.printf("%n");
            System.out.printf("O Número informado é: "+numero);
            System.out.printf("%n");
        }


        sc.close();
    }
}
