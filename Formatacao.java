public class Formatacao {
    public static void main(String[] args) {
        String produto = "Teclado";
        int quantidade = 2;
        double preco = 89.90;

        System.out.printf("Produto: %s%nQuantidade: %d%nPreço: %.2f%n",produto,quantidade,preco);
    }
}
