public class Agencia {
    private int numero;
    private String nome;

    public Agencia(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void mostrarDados() {
        System.out.println("Número da agência: " + numero);
        System.out.println("Nome da agência: " + nome);
    }
}