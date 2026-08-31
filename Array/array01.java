package Array;

import java.util.Scanner;

public class array01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String [] produto = {};
        int [] quantidade = {};

        int op = 0;

        while (op!=6) {
            System.out.println("=== SISTEMA ===");
            System.out.println("1 - Cadastra Produto");
            System.out.println("2 - Lista dos Produtos");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Alterar Produto");
            System.out.println("5 - Remover Produto");
            System.out.println("6 - Sair do Sistema");
            System.out.printf("Informe a Opção que deseja: ");
            op = sc.nextInt();
            sc.nextLine();


            switch (op) {
                case 1:
                    for(int i = 0 ; i<produto.length;i++) {
                        System.out.printf("Informe o Nome do Produto: ");
                        produto[i] =sc.nextLine();
                        System.out.printf("Informe a Quantidade do Produto: ");
                        quantidade[i]=sc.nextInt();
                    }
                    break;
            
                default:
                    System.out.println("Opção invalida!");
                    break;
                }
                
                
            }
        sc.close();
    }
}
