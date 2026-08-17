import java.util.Scanner;

public class atvCond7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("------- CD´S ------ %n    | CORES : %n  1 | VERDE %n  2 | AZUL %n  3 | AMARELO %n  4 | VERMELHO %n");

        System.out.println("Escolha O codigo da cor do CD: ");
        int cor = sc.nextInt();
        
        if (cor==1) {
            System.out.println("CD VERDE || VALOR : R$ 10,00");
        }else if (cor == 2){
            System.out.println("CD AZUL || VALOR R$ 20,00 ");
        }else if (cor == 3){
            System.out.println("CD AMARELO || VALOR R$ 30,00");
        }else if (cor == 4){
            System.out.println("CD VERMELHO || VALOR R$ 40,00");
        }else{
            System.out.println("Cor invalida ou Digitado errado.");
        }

        sc.close();
    }
}
