#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define max 400

void inverter_String(char palavra[], int i, int j);

int main() {
    char palavra[max];
    
    int fim = 1;

    do {
      fgets(palavra, max, stdin);
      palavra[strcspn(palavra, "\n")] = 0; 
         
      if (strcmp(palavra, "FIM") == 0) {
         fim = 0;
      } 
      else{
         int tam = strlen(palavra) - 1;

         inverter_String(palavra, 0, tam);

         printf("%s\n", palavra);
      }

    } while (fim);

    return 0;
}

void inverter_String(char palavra[], int i, int j) {
    
   if (i >= j) {
      return;
    }
    
    char temp = palavra[i];
    palavra[i] = palavra[j];
    palavra[j] = temp;

    inverter_String(palavra, i + 1, j - 1);
}



