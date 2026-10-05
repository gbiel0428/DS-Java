import java.io.FileWriter;
import java.io.IOException;

public class ex04 {
    public static void main(String[] args) {
        
        try{
            FileWriter fw =new  FileWriter("dado.txt");

            fw.write("primeira linha\n");
            fw.write("segunda linha\n");
            fw.close();
            System.out.println("Escrita Concluida");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
