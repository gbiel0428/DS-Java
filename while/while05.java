import java.util.Scanner;

public class while05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op =0;

        while (op!=5) {
            System.out.println("===MENU===");
            System.out.println("1- Cadastro");
            System.out.println("2- Lista");
            System.out.println("3- Alterar");
            System.out.println("4- Remover");
            System.out.println("5- Sair");
            System.out.printf("Escolha uma opção: ");
            op=sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Cadastrar");
                    break;
                case 2:
                    System.out.println("Lista");
                    break;
                case 3:
                    System.out.println("Alterar");
                    break;
                case 4:
                    System.out.println("Remover");
                    break;
                case 5:
                    System.out.println("Encerrando");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }

        sc.close();
    }
}
