import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ex08 {
    public static void main(String[] args) {
        
        try{
            File arquivo = new File("arquivo.txt");
            if(arquivo.createNewFile()){
                System.out.println("Arquivo criado com Sucesso!"+ arquivo.getName());
            }else{
                System.out.println("Arquivo ja Existe.");
            }
        }catch(Exception e){
            System.out.println("Erro ao criar o arquivo.");
            e.printStackTrace();
        }

        // Escrever no arquivo
        try{
            FileWriter writer= new FileWriter("arquivo.txt");
            writer.write("Ola, este e o conteudo inicial.");
            writer.write("Linha 2 do arquivo.");
            writer.close();
            System.out.println("Escrita concluida");
        }catch(IOException e){
            System.out.println("Erro ao escrever no arquivo." + e.getMessage());
        }
        // Ler o arquivo
        try{
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            System.out.println("Conteudo do arquivo:");
            while((linha = reader.readLine()) != null){
                System.out.println(linha);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo." + e.getMessage());
        }
        // alterar o arquivo
        
    }
}
