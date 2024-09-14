import java.util.Scanner;

class Palindromo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra;
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
                palindromo = verificar_palindromo(palavra, tam, 0);
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
    public static boolean verificar_palindromo(String palavra, int j, int i){
        boolean palindromo = true;
        while(palindromo && i < j){
            if(palavra.charAt(i) != palavra.charAt(j)){
                palindromo = false;
            }
            i++;
            j--;
        }
        return palindromo;
    }
}