import java.util.Scanner;

class Main {
    public static String inverter(String txt) {
        String invertida = "";

        for (int i = txt.length() - 1; i >= 0; i--) {
            invertida += txt.charAt(i);
        }

        return invertida;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        System.out.println(inverter(txt));

        while (!txt.equals("FIM")) {
            txt = sc.nextLine();
            
            if (!txt.equals("FIM")) {
                System.out.println(inverter(txt));
            }
        }

        sc.close();
    }
}