public class ATV3 {
    public static void main(String[] args) {
        
        for (int i=1;i<=51;i++){
            if (i%2!=0) {
                System.out.println("Os Números Impares são: "+i);
                System.out.printf("%n");
            }
        }
        for (int i=52;i<=100;i++){
            if (i % 2 == 0) {
                System.out.printf("%n");
                System.out.println("Os Números Pares são: "+i);
            }
        }
    }
}
