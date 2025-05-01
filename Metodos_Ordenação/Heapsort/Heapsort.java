class Heapsort {

   public static void main(String[] args) {
      int[] array = {7, 2, 4, 9, 1, 3};

      System.out.println("Vetor original:");
      printArray(array);

      heapsort(array);

      System.out.println("Vetor ordenado:");
      printArray(array);
  }

   public static void heapsort(int[] array) {
       int n = array.length;

       // Construir o max-heap
       for (int i = n / 2 - 1; i >= 0; i--) {
           heapify(array, n, i);
       }

       // Extrair elementos do heap um por um
       for (int i = n - 1; i > 0; i--) {
           int tmp = array[0];
           array[0] = array[i];
           array[i] = tmp;

           heapify(array, i, 0);
       }
   }

   public static void heapify(int[] array, int n, int i) {
    int maior = i;
    int esq = 2 * i + 1;
    int dir = 2 * i + 2;

    if (esq < n && array[esq] > array[maior]) {
        maior = esq;
    }

    if (dir < n && array[dir] > array[maior]) {
        maior = dir;
    }

    if (maior != i) {
        int tmp = array[i];
        array[i] = array[maior];
        array[maior] = tmp;

        heapify(array, n, maior);
    }
}

   static void printArray(int[] array) {
       for (int num : array) {
           System.out.print(num + " ");
       }
       System.out.println();
   }
}
