import java.util.Scanner;

public class atv01 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[]nomeP = new String[5];
        int []quantidade = new int[5];

        System.out.printf("==== Cadastro de Protudo ====");
        System.out.println("\n");
        for(int i=0;i<nomeP.length;i++){
            System.out.println("Informe o Protudo: ");
            nomeP[i]=sc.nextLine();
            System.out.println("\n");
            System.out.println("Deseja Quantas Quantidade? ");
            quantidade[i]=sc.nextInt();
            sc.nextLine();
        }
        // Listar

        System.out.println("\nLista Atual.");
        for(int i=0;i<nomeP.length;i++){
            System.out.println("Suas Posições:" +i+ "ª " +nomeP[i]+"  Quantidade: " +quantidade[i]);
        }

        // Buscar Protudo.

        




        sc.close();
    }
}
