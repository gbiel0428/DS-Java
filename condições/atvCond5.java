import java.util.Scanner;


public class atvCond5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a Senha: ");
        String senha = sc.next();

        if (senha.equals("abc123")) {
            System.out.println("PORTA ABERTA");
        }else {
            System.out.println("SENHA NAO CONFERER");
        }



        sc.close();
    }
}
