import java.util.Scanner;

public class atv02 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int op =0;

        while (op!=4) {
            System.out.println("===MENU===");
            System.out.println("1- Caixa de Papelão. ");
            System.out.println("2- sacola plastica. ");
            System.out.println("3- Embalagem de Vidro.");
            System.out.println("4- Sair do Menu");
            System.out.printf("Informe o Codigo do produto: ");
            op = sc.nextInt();


            switch (op) {
                case 1:
                    System.out.printf("%n");
                    System.out.println("Caixa de Papelão -  Ideal para transporte e armazenamento. ");
                    System.out.printf("%n");
                    break;
                    case 2:
                    System.out.printf("%n");
                    System.out.println("Sacola plastica - Leve e pratica, mas pouco sustentavel. ");
                    System.out.printf("%n");
                    break;
                    case 3:
                    System.out.printf("%n");
                    System.out.println("Embalagem de vidro - Resistente e reutilizavel. ");
                    System.out.printf("%n");
                    break;
                    case 4:
                    System.out.printf("%n");
                    System.out.println("Saindo do Sistema do Menu");
                    System.out.printf("%n");
                    break;
                    default:
                    System.out.printf("%n");
                    System.out.println("Codigo do produto inexistente.");
                    System.out.printf("%n");
                    break;
            }
        }
        sc.close();
    }
}
