import java.io.File;
import java.io.IOException;

public class e01 {

    public static void main(String[] args) {
        
        try{
            File arquivo = new File("exemplo.txt");
            if(arquivo.createNewFile()){
                System.out.println("Arquivo criado com Sucesso!"+ arquivo.getName());
            }else{
                System.out.println("Arquivo ja Existe.");
            }
        }catch(IOException e){
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}