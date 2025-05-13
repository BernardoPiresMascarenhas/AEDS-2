#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int coletarPolem(int N, int K, int array[]);
int somarDigitos(int maior);

int main(){

   int N; // numero de flores 
   int K; // numero da posição de Gertrude 

   scanf("%d %d", &N, &K);

   int array[N];

   for(int i = 0; i < N; i++){
      scanf("%d", &array[i]);
   }
   
   int resp = coletarPolem(N, K, array);
   printf("%d", resp);

   return 0;
}

int coletarPolem(int N, int K, int array[]){

   int resp = 0;
   bool fim = true;

   do{
      if(K == 0){
         fim = false;
      }
      else{
         
         int pos = 0;
         int maior = 0;
   
         for(int i = 0; i < N; i++){
            if(maior < array[i]){
               maior = array[i];
               pos = i;
            }
         }
   
         int somaDigitos = somarDigitos(maior);
   
         array[pos] = maior - somaDigitos;
   
         resp = somaDigitos;
         
         K--;

      }

   }while(fim);

   return resp;
}

int somarDigitos(int maior){
   int soma = 0;

    while (maior > 0) {
      soma += maior % 10;
      maior /= 10;
    }

   return soma;
}