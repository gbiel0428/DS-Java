import java.io.BufferedWriter;
import java.io.FileWriter;

public class ex06 {
    public static void main(String[] args) {
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("dado.txt", true));
            bw.write("Terceira linha");
            bw.write("Quarta linha");
            bw.newLine();
            bw.write("Quinta linha");

            bw.close();
            System.out.println("Escrita concluida");
        }catch(Exception e){
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
