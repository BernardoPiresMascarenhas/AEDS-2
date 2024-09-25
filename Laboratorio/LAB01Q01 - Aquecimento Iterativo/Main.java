import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavra;
        boolean fim = true;
        int cont = 0;

        do {
            palavra = scanner.nextLine();
            
            palavra = palavra.trim(); 
            
            int tam = palavra.length();

            if (palavra.equals("FIM")) {
                fim = false;
                
            }
            else{
               for (int i = 0; i < tam; i++) {
                  if (Character.isUpperCase(palavra.charAt(i))) {
                   cont++;
                  }
               }
               System.out.println(cont);

               cont = 0;
            }

        } while (fim);

        scanner.close();
    }
}
