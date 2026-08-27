package Array;

import java.util.Scanner;

public class array05 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String [] alunos ={"Didi", "Dede" , "Mussum", "Zacarias"};
        double[] notas = {8.5 , 7.0 ,  9.2 , 6.8 };
        
        for(int i=0;i<alunos.length;i++){
            if (notas[i]<7) {
                System.out.println("Aluno: "+alunos[i]+ "-Nota: "+notas[i]+ "= Reprovado.");}
            else{
                System.out.println("Aluno: "+alunos[i]+ "-Nota: "+notas[i]+ "= Aprovado.");
            }
}
        sc.close();
    }
}

