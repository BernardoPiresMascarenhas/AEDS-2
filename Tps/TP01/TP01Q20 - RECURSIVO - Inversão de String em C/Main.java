import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fim = true;
        String palavra;

        do {
            palavra = sc.nextLine();

            if (palavra.equals("FIM")) {
                fim = false;
            } else {
                char[] caracteres = palavra.toCharArray();
                inverter_String(caracteres, 0, palavra.length() - 1);
                System.out.println(new String(caracteres));
            }
        } while (fim);

        sc.close();
    }

    public static void inverter_String(char[] palavra, int i, int j) {
        if (i >= j) {
            return; 
        }
        
        
        char temp = palavra[i];
        palavra[i] = palavra[j];
        palavra[j] = temp;

        
        inverter_String(palavra, i + 1, j - 1);
    }
}
