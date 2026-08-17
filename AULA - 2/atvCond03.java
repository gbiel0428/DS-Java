import java.util.Scanner;

public class atvCond03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a Idade: ");
        int idade =sc.nextInt();

        if (idade<=12) {
            System.out.println("Criança.");
        }else if(idade <18){
            System.out.println("Adolescente.");
        }else if(idade<60){
            System.out.println("Adulto.");
        }else {
            System.out.println("Idoso.");
        }
        

        sc.close();
    }
}
