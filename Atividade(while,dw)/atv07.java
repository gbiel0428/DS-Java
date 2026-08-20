import java.util.Scanner;

public class atv07 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String nome ="";

        while (!nome.equals("Anderson")) {
            System.out.println("Informe o nome de um professor: ");
            nome = sc.nextLine();
        }
        System.out.println("Programa Encerrado.");

        sc.close();
    }
}
