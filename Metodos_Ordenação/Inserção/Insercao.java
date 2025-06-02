import java.util.Scanner;

class Incercao{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++){
            int aux = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > aux){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }

        for(int i = 0; i < n; i++){
            System.out.print(array[i]);
        }


        sc.close();
    }
}