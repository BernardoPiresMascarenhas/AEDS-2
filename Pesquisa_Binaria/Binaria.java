import java.util.Scanner;

class Binaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean resposta = false;
        int x;
        x = sc.nextInt();

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int n = array.length;
        int direita = n - 1;
        int esquerda = 0;
        int meio = 0;

        while(esquerda <= direita){
            meio = (direita + esquerda) / 2;
            if(x == array[meio]){
                resposta = true;
                esquerda = n;
            }
            else if(x > array[meio]){
                esquerda = meio + 1;
            }
            else{
                direita = meio - 1;
            }
        }

        if(resposta){
            System.out.println("Foi encontrado seu numero na posição: " + meio);
        }
        else{
            System.out.println("Não foi encontrado seu numero no array");
        }
        sc.close();
    }
}
