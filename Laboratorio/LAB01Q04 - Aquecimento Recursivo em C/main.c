#include <stdio.h>
#include <string.h>
#include <ctype.h>

void caracteres_maiusculos_recursivo(char palavra[], int tam, int i, int *cont) {

    if (i == tam) {
        return;
    }
    if (isupper(palavra[i])) {
        (*cont)++;
    }


    caracteres_maiusculos_recursivo(palavra, tam, i + 1, cont);
}

int main(void) {
    char palavra[100];
    int fim = 1;

    do {

        fgets(palavra, 100, stdin);
        palavra[strcspn(palavra, "\n")] = '\0';

        int tam = strlen(palavra);

        if (strcmp(palavra, "FIM") == 0) {
            fim = 0;
            break;
        }else{
         int cont = 0;
         caracteres_maiusculos_recursivo(palavra, tam, 0, &cont);
         printf("%d\n", cont);
        }

    } while (fim);

    return 0;
}
