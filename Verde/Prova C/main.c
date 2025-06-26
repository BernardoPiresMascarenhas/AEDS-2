#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void ordenar(int arrayPackage[], int tam);
void swap(int arrayOrdenado[], int i, int j);

int main(){
   
   int entrada;   // 1 ou 0
   int numero;  // Package 005
   char palavra[20];
   int arrayNumero[10];
   int continuar = 1;

   while(continuar == 1 && scanf("%d", &entrada) != EOF){

      if(entrada == 1){
         for(int i = 0; i < 5; i++){
            scanf("%s %d", palavra, &numero);
            arrayNumero[i] = numero;
         }
         
         ordenar(arrayNumero, 5);
         
      }
      else if(entrada == 0 ){

         printf("\n");

         for(int i = 0; i < 3; i++){
            scanf("%s %d", palavra, &numero);
            arrayNumero[i] = numero;
         }
         
         ordenar(arrayNumero, 3);
         continuar = 0;
      }
   }


   return 0;
}

void ordenar(int arrayNumero[], int tam){
   
   int arrayOrdenado[10];
   
   for(int i = 0; i < tam; i++){
      arrayOrdenado[i] = arrayNumero[i];
   }

   //ordenar
   for(int i = 0; i < tam; i++) {
    int menor = i;
    for(int j = i + 1; j < tam; j++) {
      if(arrayOrdenado[menor] > arrayOrdenado[j]) {
         menor = j;
      }
    }
      swap(arrayOrdenado, i, menor);
   }

   //imprimir 
   for(int i = 0; i < tam; i++){
      printf("Package 00%d\n", arrayOrdenado[i]);
   }
}

void swap(int arrayOrdenado[], int i, int j){
   int aux = arrayOrdenado[i];
   arrayOrdenado[i] = arrayOrdenado[j];
   arrayOrdenado[j] = aux;
}