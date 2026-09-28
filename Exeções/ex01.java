package Exeções;

public class ex01 {
    public static void main(String[] args) {
        int a = 10;
        int b =2;

        try{
            int resultado = a/b;
            System.out.println("RESULTADO: "+resultado);
        }catch(ArithmeticException e){
            System.out.println("Erro: Não é possivel dividir por zero!");
        }finally{
            System.out.println("Encerrado.");
        }
    }
}
