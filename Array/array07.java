package Array;
import java.util.Scanner;

public class array07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nomeP = new String[5];
        int[] quantidade = new int[5];
        int qtd = 0, opcao = 0;

        while (opcao != 6) {

            System.out.println("\n1-Cadastrar\n2-Listar\n3-Pesquisar\n4-Alterar\n5-Remover\n6-Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                if (qtd < 5) {
                    System.out.print("Produto: ");
                    nomeP[qtd] = sc.nextLine();
                    System.out.print("Quantidade: ");
                    quantidade[qtd] = sc.nextInt();
                    sc.nextLine();
                    qtd++;
                } else {
                    System.out.println("Limite atingido!");
                }
            }

            if (opcao == 2) {
                for (int i = 0; i < qtd; i++)
                    System.out.println(i + " - " + nomeP[i] + " - " + quantidade[i]);
            }

            if (opcao == 3) {
                System.out.print("Buscar: ");
                String busca = sc.nextLine();

                for (int i = 0; i < qtd; i++)
                    if (nomeP[i].equalsIgnoreCase(busca))
                        System.out.println(nomeP[i] + " - " + quantidade[i]);
            }

            if (opcao == 4) {
                System.out.print("Alterar: ");
                String busca = sc.nextLine();

                for (int i = 0; i < qtd; i++)
                    if (nomeP[i].equalsIgnoreCase(busca)) {
                        System.out.print("Novo nome: ");
                        nomeP[i] = sc.nextLine();
                        System.out.print("Nova quantidade: ");
                        quantidade[i] = sc.nextInt();
                        sc.nextLine();
                    }
            }

            if (opcao == 5) {
                System.out.print("Remover: ");
                String busca = sc.nextLine();

                for (int i = 0; i < qtd; i++)
                    if (nomeP[i].equalsIgnoreCase(busca)) {
                        for (int j = i; j < qtd - 1; j++) {
                            nomeP[j] = nomeP[j + 1];
                            quantidade[j] = quantidade[j + 1];
                        }
                        qtd--;
                    }
            }
        }

        sc.close();
    }
}
