#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define max 400

bool palindromo_rec(char palavra[], int i, int j);

int main() {
    char palavra[max];
    bool palindromo;
    int fim = 1;

    do {
        fgets(palavra, max, stdin);
        palavra[strcspn(palavra, "\n")] = 0;

        if (strcmp(palavra, "FIM") == 0) {
            fim = 0;
        }
        else {
            int tam = strlen(palavra) - 1;
            palindromo = palindromo_rec(palavra, 0, tam);

            if (palindromo) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }

    } while (fim);

    return 0;
}

bool palindromo_rec(char palavra[], int i, int j) {
    if (i >= j) {
        return true;
    }
    if (palavra[i] != palavra[j]) {
        return false;
    }
    return palindromo_rec(palavra, i + 1, j - 1);
}

