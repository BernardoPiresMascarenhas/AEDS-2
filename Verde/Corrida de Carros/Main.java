import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); 

        Piloto[] array = new Piloto[N];

        for (int i = 0; i < N; i++) {
            String nome = sc.nextLine();
            int peso = sc.nextInt();
            int ranking = sc.nextInt();
            sc.nextLine(); 
            array[i] = new Piloto(nome, peso, ranking);
        }

        quicksort(array, 0, array.length - 1);

        for (Piloto p : array) {
            p.mostrar();
        }

        sc.close();
    }

    public static void quicksort(Piloto[] array, int esq, int dir) {
        int i = esq;
        int j = dir;
        Piloto pivo = array[(i + j) / 2];

        while (i <= j) {
            while (comparar(array[i], pivo) < 0) {
                i++;
            }
            while (comparar(array[j], pivo) > 0) {
                j--;
            }
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j) {
            quicksort(array, esq, j);
        }
        if (i < dir) {
            quicksort(array, i, dir);
        }
    }

    public static int comparar(Piloto a, Piloto b) {
        if (a.peso != b.peso) {
            return a.peso - b.peso;
        } else {
            return a.ranking - b.ranking;
        }
    }

    public static void swap(int i, int j, Piloto[] array) {
        Piloto aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}

class Piloto {
    String nome;
    int peso;
    int ranking;

    public Piloto(String nome, int peso, int ranking) {
        this.nome = nome;
        this.peso = peso;
        this.ranking = ranking;
    }

    public void mostrar() {
        System.out.println(nome + " " + peso + " " + ranking);
    }
}
