import java.util.Scanner;

class Bolha{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        for(int i = 0; i < n -1; i++){
            int troca  = 0;
            for(int j = 0; j < (n - 1 - i); j++){
                if(array[j] > array[j + 1]){
                    troca = 1;
                    int aux = array[j];
                    array[j] = array[j +1];
                    array[j + 1] = aux;
                }
            }
            if(troca == 0){
                i = n;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(array[i]);
        }
        sc.close();
    }
}