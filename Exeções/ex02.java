package Exeções;

// exceção é um evento que ocorre durante a execução de um programa que interrompe o fluxo normal de instruções.
// catch significa capturar, ou seja, capturamos a exceção e tratamos ela de forma adequada para que o programa não pare de funcionar.
// try significa tentar, ou seja, tentamos executar o código que pode gerar uma exceção e caso gere, ele vai para o catch.
// finally significa finalmente, ou seja, ele vai executar o código que estiver dentro do bloco finally independente se houve ou não uma exceção.
public class ex02 {
    public static void main(String[] args) {
        int [] numeros = {10 , 20 , 30};

        try{
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fora dos limites do array");
        }finally{
            System.out.println("Encerrado.");
        }
    }
}
