import java.util.Scanner;

class Is{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String digitado;
        boolean fim = true;
        do{
            digitado = sc.nextLine();
            if(digitado.equals("FIM")){
                fim = false;
            }
            else{
                if(vogal(digitado)){
                    System.out.print("SIM ");
                }
                else{
                    System.out.print("NAO ");
                }

                if(consoante(digitado)){
                    System.out.print("SIM ");
                }
                else{
                    System.out.print("NAO ");
                }

                if(inteiro(digitado)){
                    System.out.print("SIM ");
                }
                else{
                    System.out.print("NAO ");
                }

                if(real(digitado)){
                    System.out.println("SIM ");
                }
                else{
                    System.out.println("NAO ");
                }

            }
        }while(fim);

        sc.close();
    }
    public static boolean vogal(String digitado){
        return Teste_vogal(digitado, 0);
    }
    public static boolean Teste_vogal(String digitado, int i){
        int tam = digitado.length();
        if(i == tam){
            return true;
        }

        if(digitado.charAt(i) == 'a' || digitado.charAt(i) == 'e' || digitado.charAt(i) == 'i' || digitado.charAt(i) == 'o' || digitado.charAt(i) == 'u' || digitado.charAt(i) == 'A' || digitado.charAt(i) == 'E' ||digitado.charAt(i) == 'I' ||digitado.charAt(i) == 'O' ||digitado.charAt(i) == 'U'){
            return Teste_vogal(digitado, i + 1);
        }
        else{
            return false;
        }  
        
    }
    
    public static boolean consoante(String digitado){
        return Teste_consoante(digitado, 0);
    }
    public static boolean Teste_consoante(String digitado, int i){
        int tam = digitado.length();

        if(i == tam){
            return true;
        }

        char letra = digitado.charAt(i); 
        if(digitado.charAt(i) != 'a' && digitado.charAt(i) != 'e' && digitado.charAt(i) != 'i' && digitado.charAt(i) != 'o' && digitado.charAt(i) != 'u' && digitado.charAt(i) != 'A' && digitado.charAt(i) != 'E' &&digitado.charAt(i) != 'I' &&digitado.charAt(i) != 'O' &&digitado.charAt(i) != 'U' && !Character.isDigit(letra)){
            return Teste_consoante(digitado, i + 1);
        }
        else{
            return false;
        }
        
    }

    public static boolean inteiro(String digitado){
        return Teste_inteiro(digitado, 0);
    }
    public static boolean Teste_inteiro(String digitado, int i){
        int tam = digitado.length();

        if(i == tam){
            return true;
        }

        char letra = digitado.charAt(i);

        if(Character.isDigit(letra)){
            return Teste_inteiro(digitado, i + 1);
        }
        else{
             return false;
        }
    }

    public static boolean real(String digitado){
        return Teste_real(digitado, 0);
    }
    public static boolean Teste_real(String digitado, int i){
        int tam = digitado.length();

        if(i == tam){
            return true;
        }

        char letra = digitado.charAt(i);

        if(Character.isDigit(letra) || letra == '.'){
            return Teste_real(digitado, i + 1);
        }
        else{
            return false;
        }
    }
}
