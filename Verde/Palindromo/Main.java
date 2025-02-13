import java.util.Scanner;

class Main{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      boolean fim = false;
      String palavra;
      int tamanho = 0;
      int cont = 0;

      do{
         palavra = sc.nextLine();
         tamanho = palavra.length();
         
         if(palavra.equals("FIM")){
            fim = true;
         }
         else{ 
            boolean ehPalindromo = true;

            for (int i = 0; i < tamanho / 2; i++) { 
               if (palavra.charAt(i) != palavra.charAt(tamanho - i - 1)) {
                  ehPalindromo = false;
                  i = tamanho; 
               }
            }

            if (ehPalindromo) {
               System.out.println("SIM");
            } 
            else {
               System.out.println("NAO");
            }
         }
         
      }while(!fim);
     
      sc.close();
   }
}