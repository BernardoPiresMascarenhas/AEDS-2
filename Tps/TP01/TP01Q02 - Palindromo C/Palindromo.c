#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

int main(void) {

    char palavra[400];
    int fim = 1;

    do {

        fgets(palavra, 400, stdin);


        palavra[strcspn(palavra, "\n")] = '\0';


        if (strcmp(palavra, "FIM") == 0) {
            fim = 0;
        }
        else{
             int i = 0;
             int j = strlen(palavra) - 1;
             bool palindromo = true;


            while (palindromo && i < j) {

                  if(palavra[i] != palavra[j]){
                      palindromo = false;
                   }
                  i++;
                  j--;
            }


            if (palindromo) {
                printf("SIM\n");
            }
            else {
                printf("NAO\n");
            }

        }


    } while (fim);

    return 0;
}
