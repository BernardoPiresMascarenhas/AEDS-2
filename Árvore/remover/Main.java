import java.util.*;


class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Arvore arvore = new Arvore();

      String linha = sc.nextLine();

      while(!linha.equals("FIM_INSERCAO")){
         Carro carro = new Carro();
         carro.ler(linha);
         arvore.inserir(carro);

         linha = sc.nextLine();
      }

      String placa = sc.nextLine();

      while(!placa.equals("FIM_REMOCAO")){
         arvore.remover(placa);
         placa = sc.nextLine();
      }

      arvore.caminhar();

      sc.close();
   }
}

class Carro{
   String placa;
   String modelo;
   String tipo;
   String chassi;

   void ler(String linha){
      String[] partes = linha.split(",");
      placa = partes[0];
      modelo = partes[1];
      tipo = partes[2];
      chassi = partes[3];
   }

   void imprimir(){
      System.out.println(placa + " " + modelo + " " + tipo + " " + chassi);
   }
}

class No{
   Carro carro;
   No esq, dir;

   No(Carro carro){
      this.carro = carro;
      this.esq = this.dir = null;
   }
}

class Arvore{
   No raiz;

   Arvore(){
      this.raiz = null;
   }

   void inserir(Carro x){
      raiz = inserir(x, raiz);
   }
   //compareTo se retornar um valor negativo é porque é menor, caso retorne um positivo é porque é uma string maior

   No inserir(Carro x, No i){
      if(i == null){
         i = new No(x);
      }
      else if(x.placa.compareTo(i.carro.placa) < 0){
         i.esq = inserir(x, i.esq);
      }
      else if(x.placa.compareTo(i.carro.placa) > 0){
         i.dir = inserir(x, i.dir);
      }

      return i;
   }

   void remover(String placa){
      raiz = remover(placa, raiz);
   }

   No remover(String x, No i){
      if(x.compareTo(i.carro.placa) < 0){
         i.esq = remover(x, i.esq);
      }
      else if(x.compareTo(i.carro.placa) > 0){
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

   No maiorEsq(No i, No j){
      if(j.dir == null){
         i.carro = j.carro;
         j = j.esq;
      }
      else{
         j.dir = maiorEsq(i, j.dir);
      }
      return j;
   }

   void caminhar(){
      caminhar(raiz);
   }

   void caminhar(No i){
      if(i != null){
         caminhar(i.esq);
         i.carro.imprimir();
         caminhar(i.dir);
      }
   }
}