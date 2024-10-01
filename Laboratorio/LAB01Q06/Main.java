import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        quicksortPrimeiro(0, n -1, array);
        

        sc.close();
    }
    public static void quicksortPrimeiro(int esq, int dir, int[] array){
        int i = esq;
        int j = dir;
        int pivo = array[esq];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksortPrimeiro(esq, j, array);
        if (i < dir)  quicksortPrimeiro(i, dir, array);
    }
    public static void quicksortUltimo(int esq, int dir, int[] array){
        int i = esq;
        int j = dir;
        int pivo = array[dir];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksortUltimo(esq, j, array);
        if (i < dir)  quicksortUltimo(i, dir, array);
    }
    public static void quicksortRandom(int esq, int dir, int[] array){
       
        int i = esq;
        int j = dir;
        int pivo = array[(gerador.nextInt(dir - esq + 1) + esq)];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksortRandom(esq, j, array);
        if (i < dir)  quicksortRandom(i, dir, array);
    }   
    public static void swap(int i, int j, int[] array){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}