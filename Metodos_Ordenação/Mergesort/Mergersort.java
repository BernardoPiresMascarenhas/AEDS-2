import java.util.Scanner;

class Megersort{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int[] array = new int[n];
      
      for(int i = 0; i < n; i++){
         array[i] = sc.nextInt();
      }

      dados(n, array);

      for(int i = 0; i < n; i++){
         System.out.print(array[i] + " ");
      }
      
      sc.close();
   }
   public static void dados(int n, int[] array){
      megersort(0, n - 1, array);
   }
   public static void megersort(int esq, int dir, int[] array){
      if(esq < dir){
         int meio = (esq + dir) / 2;
         megersort(esq, meio, array);
         megersort(meio + 1, dir, array);
         intercalar(esq, meio, dir, array);
      }
   }
   public static void intercalar(int esq, int meio, int dir, int[] array){
      int tam_esq = (meio + 1) - esq;
      int tam_dir = dir - meio;
      
      int[] arrayEsq = new int[tam_esq + 1];
      int[] arrayDir = new int[tam_dir + 1];

      arrayEsq[tam_esq] = arrayDir[tam_dir] = 0x7FFFFFFF;

      int iEsq, iDir, i;

      for(iEsq = 0; iEsq < tam_esq; iEsq++){
         arrayEsq[iEsq] = array[esq + iEsq];
      }

      for(iDir = 0; iDir < tam_dir; iDir++){
         arrayDir[iDir] = array[(meio + 1) + iDir];
      }

      for(iEsq = iDir = 0, i = esq; i <= dir; i++){
         array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
      }
   }
}