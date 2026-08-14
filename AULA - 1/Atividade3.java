public class Atividade3 {
    public static void main(String[] args) {
        
        String cliente = "Maria";
        String produto = "Mouse";
        int quantidade = 3;
        double valor = 45.90;
        double total = quantidade * valor;

    System.out.printf(" -------NOTA FISCAL ------- %n |Cliente: %s%n | Produto: %s%n | Quantidade: %d%n | Valor: %.2f%n | TOTAL: %.2f%n",cliente,produto,quantidade,valor,total);
    }
}
