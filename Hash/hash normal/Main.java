import java.util.*;


class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      

      String linha = sc.nextLine();

      while(!linha.equals("FIM_INSERCAO")){
         Carro carro = new Carro();


         linha = sc.nextLine();
      }

      String placa = sc.nextLine();

      while(!placa.equals("FIM_REMOCAO")){
         
      }

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

class Hash{
   int[] tabela;
   int TAM = 100;
}
