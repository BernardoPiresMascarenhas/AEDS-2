import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      sc.close();
   }
}


class No{
   int elemento;
   No esq, dir;

   public No(int elemento) {
      this(elemento, null, null);
   }

   public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

}

class Arvore{
   
   private No raiz;
    
   public Arvore() {
		raiz = null;
	}

   public boolean pesquisar(int x){
      return pesquisar(x, raiz);
   }

   public boolean pesquisar(int x, No i){
      boolean resp;
      if(i == null){
         resp = false;
      }
      else if(x == i.elemento){
         resp = true;
      }
      else if(x < i.elemento){
         resp = pesquisar(x, i.esq);
      }
      else{
         resp = pesquisar(x, i.dir);
      }
      return resp;
   }

   public void inserir(int x){
       raiz = inserir(x, raiz);
   }

   public No inserir(int x, No i){
      if(i == null){
         i = new No(x);
      }
      else if(x < i.elemento){
         i.esq = inserir(x, i.esq);
      }
      else if(x > i.elemento){
         i.dir = inserir(x, i.dir);
      }
      else{
         System.out.println("Erro!");
      }
      return i;
   }
   
   public void remover(int x){
      raiz = remover(x, raiz);
   }
   
   public No remover(int x, No i){
      if(i == null){
         System.out.println("Erro!");
      }
      else if(x < i.elemento){
         i.esq = remover(x, i.esq);
      }
      else if(x > i.elemento){
         i.dir = remover(x, i.dir);
      }
      else if(i.dir == null){
         i = i.esq;
      }
      else if(i.esq == null){
         i = i.dir;
      }
      else{
         i.esq = maiorEsq(i, i.esq);
      }
      return i;
   }

   public No maiorEsq(No i, No j){
      if(j.dir == null){
         i.elemento = j.elemento;
         j = j.esq;
      }
      else{
         j.dir = maiorEsq(i, j.dir);
      }
      return j;
   }

   // somar todos os elementos 
   public int soma(){
      return soma(raiz);
   }

   public int soma(No i){
      int resp = 0;
      if(i != null){
         resp = i.elemento + soma(i.esq) + soma(i.dir);
      }
      return resp;
   }
   
   //numeros pares
   public int numPares(){
      return numPares(raiz);
   }

   public int numPares(No i){
      if(i == null){
         return 0;
      }
      
      int contagemAtual;
      
      if(i.elemento % 2 == 0){
         contagemAtual = 1;
      }
      else{
         contagemAtual = 0;
      }

      int contagemEsquerda = numPares(i.esq);
      int contagemDireita = numPares(i.dir);

      return contagemAtual + contagemEsquerda + contagemDireita;
   }

   public void caminhar(){
      caminhar(raiz);
   }

   public void caminhar(No i){
      if(i != null){
         caminhar(i.esq);
         System.out.println(i.elemento + " ");
         caminhar(i.dir);
      }
   }
}
