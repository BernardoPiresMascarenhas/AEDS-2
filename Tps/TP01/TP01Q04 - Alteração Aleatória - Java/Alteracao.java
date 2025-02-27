import java.util.Random;
import java.util.Scanner;

public class Alteracao {
        private static Random gerador = new Random();
       
        public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean fim = true;
        String Nova_palavra;
        int tam = 0;
        gerador.setSeed(4);

        do{
            
            String palavra = sc.nextLine();
            tam = palavra.length();
            
            if (palavra.quals("FIM")) {
                fim = false;
            } 
            else{
                Nova_palavra = Alteracao_aleatoria(palavra);
                System.out.println(Nova_palavra);
            }

        }while(fim);
        
        sc.close();
    }

    public static String Alteracao_aleatoria(String palavra){
        
        char letra1, letra2;
        
        int numGerado = Math.abs(gerador.nextInt()) % 26;
        letra1 = (char) ('a' + numGerado);

        int numGerado2 = Math.abs(gerador.nextInt()) % 26;
        letra2 = (char) ('a' + numGerado2);

        int tam = palavra.length();
        
        StringBuilder novaPalavra = new StringBuilder(palavra);

        for (int i = 0; i < tam; i++) {
            if (palavra.charAt(i) == letra1) {
                novaPalavra.setCharAt(i, letra2);
            }
        }

        return novaPalavra.toString();
    }
    
}
