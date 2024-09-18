import java.util.Scanner;

class Palindromo{
    public static void main(String[] args){
        String palavra;
        Scanner sc = new Scanner(System.in);
        boolean fim = true;
        boolean palindromo;
        int tam = 0;
        do{
            palavra = sc.nextLine();
            if(palavra.equals("FIM")){
                fim = false;
            }
            else{
                tam = palavra.length() - 1;
                palindromo = palindromo_fun(palavra, 0, tam);

                if(palindromo){
                    System.out.println("SIM");
                }
                else{
                    System.out.println("NAO");
                }
            }

        }while(fim);
        
        sc.close();
    }

    public static boolean palindromo_fun(String palavra, int i, int j){

        if(i >= j){
            return true;
        }
        if (palavra.charAt(i) != palavra.charAt(j)) {
            return false;
        }
        return palindromo_fun(palavra, i + 1, j - 1);
    }
}