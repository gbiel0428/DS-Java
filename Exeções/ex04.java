package Exeções;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Informe o nome: ");
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser vazio.");
            }
            System.out.println("O nome informado é: " + nome);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}