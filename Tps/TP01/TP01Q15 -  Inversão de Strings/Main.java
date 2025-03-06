import java.util.Scanner;

class Main{

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
   
      boolean fim = true;
      String palavra;

      do{
         palavra = sc.nextLine();

         if(palavra.equals("FIM")){
            fim = false;
         }  
         else{
            
            String invertida = inverter_String(palavra);

            System.out.println(invertida);
         }
       
      }while(fim);
      
      sc.close();
   }

   public static String inverter_String(String palavra){
      
      StringBuilder newPalavra = new StringBuilder(palavra);
      
      return newPalavra.reverse().toString();

   }
}