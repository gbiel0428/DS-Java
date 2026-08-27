import java.util.Scanner;

public class ATV6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int op =0;

        while (op!=3) {
            System.out.println("=== MENU ===");
            System.out.println("1 -  Tabuada");
            System.out.println("2 -  Realizar contagem Regressiva");
            System.out.println("3 -  Sair do Menu");
            System.out.println("Informe o Codigo da Opção que deseja Realizar: ");
            op = sc.nextInt();



            switch (op) {
                case 1:
                    System.out.println("Infore o Número que deseja para a Tabuada: ");
                    int numero = sc.nextInt();
                    for(int i=1;i<=10;i++){
                        System.out.println(numero+ " x " +i+ " = " +(numero*i));
                    }
                    break;
                case 2:
                    System.out.println("Informe o Número para a Contagem Regressiva: ");
                    int cont = sc.nextInt();
                    for(int i=cont;i>=0;i--){
                        System.out.println("Os Números são: "+i);
                    }
                    break;
                case 3:
                    System.out.println("Saindo do Menu...");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }

        sc.close();
    }
}
