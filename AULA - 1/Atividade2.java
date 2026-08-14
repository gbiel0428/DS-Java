import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print( "Informe o nome do Aluno:");
        String nome = sc.next();

        System.out.print("Informe a 1- NOTA DO ALUNO:");
        int nota1 = sc.nextInt();

        System.out.print("Informe a 2- NOTA DO ALUNO:");
        int nota2= sc.nextInt();

        double media= (nota1 + nota2) / 2;

        System.out.printf("Aluno: %s  | 1-NOTA: %d   | 2-NOTA: %d  | Media: %.2f",nome,nota1,nota2,media);
        sc.close();
    }
}
