import java.util.Scanner;


//  A condição && so libera quando os 2 estive batendo.
public class Cond02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("informe a  Primeira Nota do Aluno: ");
        double nota = sc.nextDouble();

        System.out.println("Informe a Segunda Nota do Aluno: ");
        double nota2 = sc.nextDouble();

        System.out.println("Informe a Terceira Nota do Aluno: ");
        double nota3 = sc.nextDouble();
        System.out.println("Informe a frequencia do Aluno: ");
        double frequencia = sc.nextDouble();

        double media = (nota  + nota2 + nota3) / 3;
        if (media>=7 && frequencia>=75 ) {

            System.out.println("Aprovado.");
        }else {
            System.out.println("Reprovado.");
        }



        sc.close();
    }
}
