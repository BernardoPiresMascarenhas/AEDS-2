import java.util.Scanner;

class Selecao{

   public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int array[] = new int[n];
 
      for(int i = 0; i < n; i++){
          array[i] = sc.nextInt();
       }                                                      //  0  1  2  3  4  5  6  7   8  9
//                                                                i  j                                                             
       for(int i = 0; i < n - 1; i++){                        //  9  4  3  7  5  2  7  10  1  2
         int menor = i;                                      // menor
         for(int j = (i + 1); j < n; j++){
            if(array[menor] > array[j]){
               menor = j;
            }
         }
         swap(menor, i, array);
       }

       for(int i = 0; i < n; i++){
        System.out.print(array[i]);
       }

   sc.close();

   }

   public static void swap(int menor, int i, int array[]){
       int aux = array[menor];
       array[menor] = array[i];
       array[i] = aux;
   }
}