import java.util.Scanner;

public class Dwh03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String senha= "";

        do{
            System.out.println("Informe a Senha: ");
            senha = sc.nextLine();
        }while(!senha.equals("1234"));
        System.out.println("Acesso permitido.");


        sc.close();
    }
}
