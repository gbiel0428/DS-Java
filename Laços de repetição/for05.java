import java.util.Scanner;

public class for05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=3;i++){
            System.out.println("Informe o " +i+ "º Nome: ");
            String nome=sc.nextLine();

            System.out.printf("%n");
            System.out.println("O Nome informado é: "+nome);
            System.out.printf("%n");
        }

        sc.close();
        
    }
    
}
