import java.util.Scanner;

class Main{

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
   
      boolean fim = true;
      String numeros;

      do{
         numeros = sc.nextLine();

         if(numeros.equals("FIM")){
            fim = false;
         }  
         else{
            int numero = Integer.parseInt(numeros);

            int resultado = somar_numeros(numero);
            
            System.out.println(resultado);
         }
       
      }while(fim);
      
      sc.close();
   }

   public static int somar_numeros(int numero){
      
      if (numero == 0) {
            return 0;
        }
      
      return numero % 10 + somar_numeros(numero / 10);
   }

}