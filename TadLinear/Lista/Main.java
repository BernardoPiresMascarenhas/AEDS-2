import java.util.Scanner;

class Main{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      Lista lista = new Lista(6);

      lista.inserirInicio(3);
      lista.inserirInicio(4);
      lista.inserirInicio(8);

      lista.inserirFim(10);
      lista.inserirInicio(2);
      lista.inserir(1,4);


      lista.mostrar();

      sc.close();
   }   
}


class Lista{
   int[] array;
   int n;

   Lista(int tamanho){
      array = new int[tamanho];
      n = 0;
   }

   void inserirInicio(int x){
      
      if(n >= array.length){
         System.err.println();       //  i
         return;                     //  0 1 2 3 4 5 
      }                              //    5 6 3 2 4 

      for(int i = n; i > 0; i--){
         array[i] = array[i - 1];
      }

      array[0] = x;
      n++;
   }

   void  inserirFim(int x){
      if(n >= array.length){
         System.err.println();
         return;
      }

      array[n] = x;
      n++;
   }

   void inserir(int x, int pos){
      if(n >= array.length || (pos < 0 || pos > n)){
         System.err.println();
         return;
      }

      for(int i = n; i > pos; i--){
         array[i] = array[i - 1];
      }

      array[pos] = x;
      n++;
   }

   void inserirOrdenado(int x){
      if(n >= array.length){
         System.err.println();
         return;
      }

      int i;

      for(i = n - 1; i >= 0 && array[i] > x; i--){
         array[i + 1] = array[i];
      }

      array[i + 1] = x;

   }

   int removerInicio(){
      if(n == 0){
         System.err.println();
         return n;
      }

      int resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i + 1];
      }

   }

   int removerFim(){
      if(n == 0){
         System.err.println();
         return n;
      }
      n--;
      return array[n];
   }

   int remover(int pos){
      if(n == 0 && pos (< 0 || pos > n)){
         System.err.println();
         return n;
      }

      int resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i + 1];
      }

      return resp;
   }


   void mostrar(){
      for(int i = 0; i < n; i++){
         System.out.print(array[i] + " ");
      }
      System.out.println();
   }


}

