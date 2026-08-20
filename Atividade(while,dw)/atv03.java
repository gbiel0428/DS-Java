import java.util.Scanner;

public class atv03 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int op=0;


        while (op!=4) {
            System.out.println("===MENU CANETAS===");
            System.out.println("1 - ESFEROGRAFICA");
            System.out.println("2-  GEL");
            System.out.println("3-   TINTEIRO");
            System.out.println("4-  Sair do Sistema de Menu");
            System.out.printf("Informe o Codigo da Caneta que deseja: ");
            op =sc.nextInt();



            switch (op) {
                case 1:
                    System.out.printf("%n");
                    System.out.println("Caneta Esferografica - Economica e de longa duração.");
                    System.out.printf("%n");
                    break;
                    case 2:
                    System.out.printf("%n");
                    System.out.println("Caneta Gel - Tinta mais pigmentada e escrita suave.");
                    System.out.printf("%n");
                    break;
                    case 3:
                    System.out.printf("%n");
                    System.out.println("Caneta Tinteira - Classica e elegante, usada para caligrafia.");
                    System.out.printf("%n");
                    break;
                    case 4:
                    System.out.printf("%n");
                    System.out.println("Saindo do Sistema de Menu.");
                    System.out.printf("%n");
                    break;
                    
                    default:
                    System.out.printf("%n");
                    System.out.println("Codigo da Caneta inexistente.");
                    System.out.printf("%n");
                    break;
            }
        }

        sc.close();
    }
}
