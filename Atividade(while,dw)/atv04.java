import java.util.Scanner;

public class atv04 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int op=0;


        while (op!=4) {
            System.out.println("===MENU Mochilas===");
            System.out.println("1 - Escolar");
            System.out.println("2-  Viagem");
            System.out.println("3-   Esportiva");
            System.out.println("4-  Sair do Sistema de Menu");
            System.out.printf("Informe o Codigo da Mochila que deseja: ");
            op =sc.nextInt();



            switch (op) {
                case 1:
                    System.out.printf("%n");
                    System.out.println("Mochila Escolar - Compacta e ideal para estudantes.");
                    System.out.printf("%n");
                    break;
                    case 2:
                    System.out.printf("%n");
                    System.out.println("Mochila De Viagem - Espaçosa, ideal para longas jornadas.");
                    System.out.printf("%n");
                    break;
                    case 3:
                    System.out.printf("%n");
                    System.out.println("Mochila Esportiva - Leve, resistente e ergonomica.");
                    System.out.printf("%n");
                    break;
                    case 4:
                    System.out.printf("%n");
                    System.out.println("Saindo do Sistema de Menu.");
                    System.out.printf("%n");
                    break;
                    
                    default:
                    System.out.printf("%n");
                    System.out.println("Codigo da Mochila inexistente.");
                    System.out.printf("%n");
                    break;
            }
        }

        sc.close();
    }
}
