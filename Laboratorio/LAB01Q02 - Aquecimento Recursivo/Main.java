import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processInput(scanner);
        scanner.close();
    }

    public static void processInput(Scanner scanner) {
        String palavra = scanner.nextLine().trim(); 

        if (palavra.equals("FIM")) {
            return; 
        }

        int upperCaseCount = countUpperCase(palavra, 0);
        System.out.println(upperCaseCount);

        processInput(scanner); 
    }

    public static int countUpperCase(String palavra, int index) {
        if (index == palavra.length()) {
            return 0; 
        }

        if (Character.isUpperCase(palavra.charAt(index))) {
            return 1 + countUpperCase(palavra, index + 1); 
        } else {
            return countUpperCase(palavra, index + 1); 
        }
    }
}