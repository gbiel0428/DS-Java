import java.util.Scanner;

public class atv01 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String senha = "";

        while (!senha.equals("2024")) {
            System.out.println("Informe a Senha: ");
            senha = sc.nextLine();
        }
        System.out.println("Acesso Permitido");
        sc.close(); 
    }

}
