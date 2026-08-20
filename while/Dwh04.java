import java.util.Scanner;

public class Dwh04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        do{
            System.out.println("1- Iniciar Jogo");
            System.out.println("2- Carregar Jogo");
            System.out.println("3- Configurações");
            System.out.println("4- Sair");
            System.out.printf("Escolha uma Opção: ");
            op=sc.nextInt();

            switch (op) {
                case 1:
                    System.out.printf("%n");
                    System.out.println("Iniciar jogo ");
                    System.out.printf("%n");
                    break;
                case 2:
                    System.out.printf("%n");
                    System.out.println("Carregar Jogo");
                    System.out.printf("%n");
                    break;
                case 3:
                    System.out.printf("%n");
                    System.out.println("Configurações");
                    System.out.printf("%n");
                    break;
                case 4:
                    System.out.printf("%n");
                    System.out.println("Saindo do Menu");
                    System.out.printf("%n");
                    break;
                default:
                    System.out.printf("%n");
                    System.out.println("Opção do Menu Invalida");
                    System.out.printf("%n");
                    break;
            }
        }while(op!=4);


        sc.close();
    }
}
