import java.util.Scanner;

public class atvCond6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o Primeiro Número: ");
        double nota1 = sc.nextDouble();

        System.out.println("Informe o Segundo Número: ");
        double nota2 = sc.nextDouble();

        System.out.println("Informe a Operação que Deseja + | -  |  /  |  *  :" );
        String op = sc.next();
        
        if (op.equals("+")) {
            double soma = (nota1 + nota2);
            System.out.printf("A soma é: %.2f",soma);
        }else if (op.equals("-")){
            double sub = (nota1 - nota2);
            System.out.printf("A Subtração é: %.2f ",sub);
        }else if (op.equals("/")){
            double div = (nota1 / nota2);
            System.out.printf("A Divisão é: %.2f",div);
        }else if (op.equals("*")){
            double mul=(nota1 * nota2);
            System.out.printf("A multiplicação é: %.2f",mul);
        }else{
            System.out.println("Opereção Incorreta.");
        }

        sc.close();
    }
}
