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
                System.out.println(ciframento_cesar(palavra));
            }

        }while(fim);
        sc.close();
    }
    public static String ciframento_cesar(String palavra){
        int tam = palavra.length();
        String alterada = "";
        char letra;

        for(int i = 0; i < tam; i++){
            letra = palavra.charAt(i);
            if(letra >= 0 && letra <= 127){
                letra+=3;
                alterada += letra;
            }
            else if(letra == '\uFFFD'){
                alterada += letra;
            }
        
        }
        return alterada;
    }
}