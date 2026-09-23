public class Conta {
    private int numero;
    private String titular;
    protected double saldo; // 'protected' permite que ContaCorrente altere o saldo
    private Agencia agencia;

    public Conta(int numero, String titular, double saldo, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito realizado!");
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void mostrarDados() {
        agencia.mostrarDados();
        System.out.println("Número da conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}