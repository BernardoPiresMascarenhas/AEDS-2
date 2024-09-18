import java.util.Scanner;

class Ciframento{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra;
        boolean fim = true;
        do{
            palavra = sc.nextLine();
            if(palavra.equals("FIM")){
                fim = false;
            }
            else{
                System.out.println(ciframento(palavra));
            }
        }while(fim);

        sc.close();
    }
    public static String ciframento_cesar(String palavra, int i, String alterada){
        int tam = palavra.length();
        char letra;
        if(i == tam){
            return alterada;
        }
        letra = palavra.charAt(i);
        if(letra != '\uFFFD'){
            letra += 3;
            alterada += letra;
        }
        else{
            alterada += letra;
        }
       
       return ciframento_cesar(palavra, i + 1, alterada);
    
    }

    public static String ciframento(String palavra){
        return ciframento_cesar(palavra, 0, "");
    }
}