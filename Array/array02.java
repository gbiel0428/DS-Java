package Array;

import java.util.Scanner;

public class array02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numeros = new int[5];
        int opcao = 0;
        int quantidade = 0;

        while (opcao!=4) {
            System.out.println("===MENU===");
            System.out.println("1- Inserir um Número: ");
            System.out.println("2- Lista  dos Número: ");
            System.out.println("3- Remover um Número:  ");
            System.out.println("4- Finalizar Programa.");
            System.out.println("Informe a Opção que deseja Realizar: ");
            opcao=sc.nextInt();
            
            switch (opcao) {
                case 1:
                    if (quantidade<numeros.length){
                        System.out.println("Adicione um Número: ");
                        numeros[quantidade] =sc.nextInt();
                        quantidade++;
                        
                        System.out.printf("%n");
                        System.out.println("Número Adicionado! ");
                    } else {
                        System.out.println("Inserção não e Possivel.");
                    }
                    break;

                case 2:
                    if (quantidade == 0) {
                        System.out.println("Nenhum Número Cadastrado.");
                    }else{
                        for (int i =0;i<quantidade;i++){
                            System.out.println(i + " - " + numeros[i]);
                        }
                    }
                    break;

                case 3:

                    if (quantidade == 0) {
                        System.out.println("Lista Vazia.");
                        break;
                    }

                    System.out.println("Informe o índice que deseja remover:");
                    int indice = sc.nextInt();

                    if (indice < 0 || indice >= quantidade) {
                        System.out.println("Índice inválido!");
                        break;
                    }

                    for (int i = indice; i < quantidade - 1; i++) {
                        numeros[i] = numeros[i - 1];
                    }
                    quantidade--;

                    System.out.println("Número removido!");

                    break;
                case 4:
                    System.out.println("Encerrando Programa.");
                    break;
                    default:
                        System.out.println("Opção Invalida.");
                        break;
                    }
                    
                }
        sc.close();
    }
}
