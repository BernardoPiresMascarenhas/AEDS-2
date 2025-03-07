import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean fim = true;
        String senha;

        do{

         senha = sc.nextLine();

         if(senha.equals("FIM")){
            fim = false;
         }
         else{
           
           boolean resultado = validarSenha(senha);

           if(resultado){
            System.out.println("SIM");
           }
           else{
            System.out.println("NAO");
           }

         }


        }while(fim);
        
        sc.close();
    }

    public static boolean validarSenha(String senha){
      int tam = senha.length();
      int cont = 0;
      
      //verificar se tem no minimo 8 caracteres 
      if(tam >= 8){
         cont++;
      }

      // verificar caractere especial
      for(int i = 0; i < tam; i++){
         if(senha.charAt(i) == '!' || senha.charAt(i) == '@' || senha.charAt(i) == '#' || senha.charAt(i) == '^'){
            cont++;
            i = tam;
         }
      }

      // verificar se tem alguma letra maiuscula presente

      for(int i = 0; i < tam; i++){
         if (senha.charAt(i) >= 65 && senha.charAt(i) <= 90) { 
            cont++;
            i = tam;
         }
      }

      // verificar se tem alguma letra minuscula presente
      
      for (int i = 0; i < tam; i++) {
         if (senha.charAt(i) >= 97 && senha.charAt(i) <= 122) { 
             cont++;
             i =  tam;
         }
      }

      //verificar se tem algum numero

      for (int i = 0; i < tam; i++) {
         if (senha.charAt(i) >= 48 && senha.charAt(i) <= 57) { 
            cont++;
            i = tam;
         }
      }

      if(cont == 5){
         return true;
      }
      else{
         return false;
      }

    }
}