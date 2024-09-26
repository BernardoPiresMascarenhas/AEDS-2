#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void) {
  char palavra[100];
  int fim = 1;
  int cont = 0;

  do{
    fgets(palavra, 100, stdin);

    palavra[strcspn(palavra, "\n")] = '\0';

    int tam = strlen(palavra);

    if (strcmp(palavra, "FIM") == 0) {
        fim = 0;
        break;
    }

    for(int i = 0; i < tam; i++){
      if(isupper(palavra[i])){
        cont++;
      }
    }
    printf("%d\n", cont);


    cont = 0;

  }while(fim);


  return 0;
}
