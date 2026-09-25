import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CADASTRO INICIAL");
        System.out.print("Número da agência: ");
        int numAgencia = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = sc.nextLine();

        Agencia agencia = new Agencia(numAgencia, nomeAgencia);

        System.out.print("Número da conta: ");
        int numConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Titular: ");
        String titular = sc.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = sc.nextDouble();

        ContaCorrente cc = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\nMENU");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("7 - Transferir (Desafio)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cc.mostrarDados();
                    break;
                case 2:
                    System.out.println("Saldo atual: R$ " + cc.consultarSaldo());
                    break;
                case 3:
                    System.out.print("Valor do depósito: R$ ");
                    double valorDep = sc.nextDouble();
                    cc.depositar(valorDep);
                    break;
                case 4:
                    System.out.print("Valor do pagamento via PIX: R$ ");
                    double valorPix = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Chave PIX: ");
                    String chavePix = sc.nextLine();
                    cc.pagar(valorPix, chavePix);
                    break;
                case 5:
                    System.out.print("Valor da compra no cartão: R$ ");
                    double valorCartao = sc.nextDouble();
                    System.out.print("Quantidade de parcelas: ");
                    int parcelas = sc.nextInt();
                    cc.pagar(valorCartao, parcelas);
                    break;
                case 6:
                    System.out.print("Valor do pagamento em dinheiro: R$ ");
                    double valorDinheiro = sc.nextDouble();
                    cc.pagar(valorDinheiro);
                    break;
                case 7:
                    System.out.print("Número da conta de destino: ");
                    int contaDestino = sc.nextInt();
                    System.out.print("Valor da transferência: R$ ");
                    double valorTransf = sc.nextDouble();
                    cc.transferir(contaDestino, valorTransf);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}

