import java.util.Scanner;


public class Quicksort {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int[] array = new int[n];
      
      for(int i = 0; i < n; i++){
         array[i] = sc.nextInt();
      }

      quickSort(array, n);

      for(int i = 0; i < n; i++){
         System.out.print(array[i] + " ");
      }

      sc.close();
   }
   public static void quickSort(int[] array, int n){
      quickSortRec(0, n - 1, array);
   }
   public static void quickSortRec(int esq, int dir, int[] array){
      int i = esq;
      int j = dir;
      int pivo = array[(dir + esq) / 2];
      while(i <= j){
         while(array[i] < pivo){
            i++;
         }
         while(array[j] > pivo){
            j--;
         }
         if(i <= j){
            swap(i, j, array);
            i++;
            j--;
         }
      }
      if(j > esq){
         quickSortRec(esq, j, array);
      }
      if(i < dir){
         quickSortRec(i, dir, array);
      }
   }
   public static void swap(int i, int j, int[] array){
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
   } 
}