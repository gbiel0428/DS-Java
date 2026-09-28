import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0;
        try {
            System.out.println("Saldo atual: R$ " + saldo);
            System.out.println("Informe o valor do saque: ");
            double valor = sc.nextDouble();
            if (valor <= 0) {
                throw new IllegalArgumentException("O valor deve ser maior que zero.");
            }
            if (valor > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente para o saque.");
            }
            saldo -= valor;
            System.out.println("Saque realizado! Novo saldo: R$ " + saldo);
        } catch (InputMismatchException e) {
            System.out.println("Erro: digite apenas números válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação encerrada");
            sc.close();
        }
    }
}