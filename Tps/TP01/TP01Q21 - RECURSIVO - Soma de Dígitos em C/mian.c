#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define max 100

int somar_numeros(int numero);

int main(void){

   char numeros[max];
   int fim = 1;

   do{
      fgets(numeros, max, stdin);
   
      numeros[strcspn(numeros, "\n")] = 0; 
   
      if (strcmp(numeros, "FIM") == 0) {
         fim = 0;
      }
      else{
         int numero = atoi(numeros); 

         int resultado = somar_numeros(numero);

         printf("%d\n", resultado);
      }

   }while(fim);


   return 0;
}

int somar_numeros(int numero){
   if (numero == 0) {
      return 0; 
   }

   return (numero % 10) + somar_numeros(numero / 10); 
}