package Array;

import java.util.Scanner;

public class array06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes;
        int[] idades;

        System.out.println("Quantas pessoas deseja cadastrar: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); 

        nomes = new String[quantidade];
        idades = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.printf("Informe o Nome: ");
            nomes[i] = sc.nextLine(); 
            
            System.out.printf("Informe a Idade: ");
            idades[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("\nPessoas cadastradas:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println(nomes[i] + " - " + idades[i] + " anos");
        }
        
        sc.close();
    }
}
