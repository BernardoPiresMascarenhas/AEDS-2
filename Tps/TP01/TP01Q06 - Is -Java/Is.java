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
        boolean vogal = true;
        int tam = digitado.length();
        int cont = 0;

        for(int i = 0; i < tam; i++){
            if(digitado.charAt(i) == 'a' || digitado.charAt(i) == 'e' || digitado.charAt(i) == 'i' || digitado.charAt(i) == 'o' || digitado.charAt(i) == 'u' || digitado.charAt(i) == 'A' || digitado.charAt(i) == 'E' ||digitado.charAt(i) == 'I' ||digitado.charAt(i) == 'O' ||digitado.charAt(i) == 'U'){
                cont++;
            }   
        }
        if(cont == tam){
            vogal = true;
        }
        else{
            vogal = false;
        }

        return vogal;

    }

    public static boolean consoante(String digitado){
        boolean consoante = true;
        int tam = digitado.length();
        int cont = 0;
        
        for(int i = 0; i < tam; i++){
            char letra = digitado.charAt(i); 
            if(digitado.charAt(i) != 'a' && digitado.charAt(i) != 'e' && digitado.charAt(i) != 'i' && digitado.charAt(i) != 'o' && digitado.charAt(i) != 'u' && digitado.charAt(i) != 'A' && digitado.charAt(i) != 'E' &&digitado.charAt(i) != 'I' &&digitado.charAt(i) != 'O' &&digitado.charAt(i) != 'U' && !Character.isDigit(letra)){
                cont++;
            }   
        }
        
        if(cont == tam){
            consoante = true;
        }
        else{
            consoante = false;
        }

        return consoante;

    }

    public static boolean inteiro(String digitado){
        try{
            Integer.parseInt(digitado);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public static boolean real(String digitado){
        try{
            Float.parseFloat(digitado);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}