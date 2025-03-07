import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean fim = true;
        String frase;

        do{

         frase = sc.nextLine();

         if(frase.equals("FIM")){
            fim = false;
         }
         else{
            String[] palavras = frase.split("\\s+");
            System.out.println(palavras.length);
         }


        }while(fim);
        
        sc.close();
    }
}