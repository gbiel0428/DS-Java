import java.io.FileWriter;
import java.io.IOException;

public class ex02 {
    public static void main(String[] args) {
        
        try{
            FileWriter escritor = new FileWriter("exemplo.txt", true);
            escritor.write("primeira linha\n");
            escritor.write("segunda linha\n");
            escritor.write("terceira linha\n");

            escritor.close();
            System.out.println("Escrita concluida");
        }catch(IOException e){
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
