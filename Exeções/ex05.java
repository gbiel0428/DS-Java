package Exeções;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ex05 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op = -1;
        while(op != 0){
            try{
                System.out.println("========== Menu ==========");
                System.out.println("1 - Adicionar item");
                System.out.println("2 - Listar item");
                System.out.println("3 - remover item");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.print("Digite o item a ser adicionado: ");
                        String item = sc.nextLine();
                        lista.add(item);
                        System.out.println("Item adicionado com sucesso!");
                        break;
                    case 2:
                        if (lista.isEmpty()){
                            System.out.println("A lista está vazia.");
                        }else{
                            System.out.println("Itens na lista: "+lista);
                        }
                        break;
                    case 3:
                        System.out.println("Digite o índice do item a ser removido: ");
                        int indice = sc.nextInt();
                        if (indice < 0 || indice >= lista.size()){
                            System.out.println("Índice inválido.");
                        }else{
                            String itemRemovido = lista.remove(indice);
                            System.out.println("Item removido: "+itemRemovido);
                        }
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Erro: Entrada inválida. Por favor, informe um número inteiro.");
                sc.nextLine();
        }catch(IndexOutOfBoundsException e){
                System.out.println("Erro: Índice fora dos limites da lista.");
                sc.nextLine();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
                sc.nextLine();
            }finally{
                System.out.println("Encerrado.");
        }
    }
}  }
