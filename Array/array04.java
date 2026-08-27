package Array;

import java.util.Scanner;

public class array04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[3];

        // Inserir

        for(int i=0;i<nomes.length;i++){
            System.out.printf("informe um Nome: ");
            nomes[i]=sc.nextLine();
            System.out.printf("%n");
        }
        System.out.println("Nomes Cadastrados: " );

        for(int i=0;i<nomes.length;i++){
            System.out.println("Suas Posições: [" +i+ "]"+nomes[i]);
        }


        sc.close();
    }
}
