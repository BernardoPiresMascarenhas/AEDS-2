import java.util.*;


class Main{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Arvore arvore = new Arvore();
      String linha = sc.nextLine();

      while(!linha.equals("FIM")){
         Carro carro = new Carro();
         carro.ler(linha);
         arvore.inserir(carro);
         
         linha = sc.nextLine();
      }

      String placa = sc.nextLine();

      while(!placa.equals("FIM_BUSCA")){
         arvore.pesquisar(placa);
         placa = sc.nextLine();
      }

      sc.close();
   }
}

class No{
   Carro carro;
   No esq, dir;

   No(Carro carro){
      this.carro = carro;
      this.dir = this.esq = null;
   }
}

class Arvore{
   No raiz;

   Arvore(){
      this.raiz = null;
   }

   void inserir(Carro carro){
      raiz = inserir(carro, raiz);
   }

   No inserir(Carro carro, No i){
      if(i == null){
         i = new No(carro);
      }
      else if(carro.placa.compareTo(i.carro.placa) < 0){
         i.esq = inserir(carro, i.esq);
      }
      else if(carro.placa.compareTo(i.carro.placa) > 0){
         i.dir = inserir(carro, i.dir);
      }

      return i;
   }


   void pesquisar(String placa){
      pesquisar(placa, raiz, 0);
   }

   void pesquisar(String placa, No i, int nivel){
      if(i == null){
         System.out.println("PLACA NAO ENCONTRADA");
      }
      else if(placa.compareTo(i.carro.placa) == 0){
         i.carro.imprimir();
         System.out.println( " (Nivel " + nivel + ")");
      }
      else if(placa.compareTo(i.carro.placa) < 0){
         pesquisar(placa, i.esq, nivel+1);
      }
      else{
         pesquisar(placa, i.dir, nivel+1);
      }
      
   }
}

class Carro {
    String placa, modelo, tipo, chassi;
    
    void ler(String linha) {
        String[] partes = linha.split(",");
        placa = partes[0];
        modelo = partes[1];
        tipo = partes[2];
        chassi = partes[3];
    }

    void imprimir() {
        System.out.print(placa + " " + modelo + " " + tipo + " " + chassi);
    }
}