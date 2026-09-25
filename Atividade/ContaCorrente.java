public class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(int numero, String titular, double saldo, Agencia agencia) {
        super(numero, titular, saldo, agencia);
    }

    
    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Pagamento em dinheiro realizado!");
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }


    public void pagar(double valor, String chavePix) {
        if (valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Pagamento via PIX realizado para a chave: " + chavePix);
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void pagar(double valor, int parcelas) {
        if (valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return;
        }
        if (parcelas <= 0) {
            System.out.println("Quantidade de parcelas inválida.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            double valorParcela = valor / parcelas;
            System.out.println("Pagamento no cartão realizado!");
            System.out.printf("Compra dividida em %d parcelas de R$ %.2f\n", parcelas, valorParcela);
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(int contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Transferência de R$ " + valor + " realizada para a conta " + contaDestino);
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }
}