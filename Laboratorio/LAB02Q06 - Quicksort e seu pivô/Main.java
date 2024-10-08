import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        
        quicksortFirstPivot(array, 0, n - 1);
        quicksortLastPivot(array, 0, n - 1);
        quicksortRandomPivot(array, 0, n - 1);
        quicksortMedianOfThree(array, 0, n - 1);

        sc.close();
    }

    public static void quicksortFirstPivot(int[] array, int esq, int dir) {
        if (esq >= dir) return; 
        int i = esq, j = dir;
        int pivo = array[esq]; 
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) quicksortFirstPivot(array, esq, j);
        if (i < dir) quicksortFirstPivot(array, i, dir);
    }

    public static void quicksortLastPivot(int[] array, int esq, int dir) {
        if (esq >= dir) return; 

        int i = esq, j = dir;
        int pivo = array[dir]; 
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) quicksortLastPivot(array, esq, j);
        if (i < dir) quicksortLastPivot(array, i, dir);
    }

    public static void quicksortRandomPivot(int[] array, int esq, int dir) {
        if (esq >= dir) return; 

        Random rand = new Random();
        int i = esq, j = dir;
        int pivoRandom = esq + rand.nextInt(dir - esq + 1); 
        int pivo = array[pivoRandom];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) quicksortRandomPivot(array, esq, j);
        if (i < dir) quicksortRandomPivot(array, i, dir);
    }

    public static void quicksortMedianOfThree(int[] array, int esq, int dir) {
        if (esq >= dir) return; 

        int i = esq, j = dir;
        int pivo = medianaDeTres(array, esq, dir); 
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j) quicksortMedianOfThree(array, esq, j);
        if (i < dir) quicksortMedianOfThree(array, i, dir);
    }

    
    public static int medianaDeTres(int[] array, int esq, int dir) {
        int meio = (esq + dir) / 2;

        int a = array[esq];
        int b = array[meio];
        int c = array[dir];

        if ((a > b && a < c) || (a < b && a > c)) return a;
        else if ((b > a && b < c) || (b < a && b > c)) return b;
        else return c;
    }

    
    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
