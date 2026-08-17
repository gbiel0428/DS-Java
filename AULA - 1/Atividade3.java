import java.util.Scanner;

public class Atividade3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("informe o Nome do Cliente: ");
        String cliente = sc.next();

        System.out.print("Informe o Nome do Produto:");
        String produto = sc.next();
        
        System.out.print("informe a Quantidade do Produto: ");
        int quantidade =sc.nextInt();
        
        System.out.print("Informe o Valor do Produto:");
        double valor = sc.nextDouble();
        double total = quantidade * valor;

    System.out.printf(" -------NOTA FISCAL ------- %n |Cliente: %s%n | Produto: %s%n | Quantidade: %d%n | Valor: %.2f%n | TOTAL: %.2f%n",cliente,produto,quantidade,valor,total);
    sc.close();
}
}
