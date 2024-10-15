  #include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
    
    int main(){

    int numCompetidor = 0;
    int ultrapassagens = 0;
    int k = 0;
    int arrayUltrapassagens[3];
    char linha[50];
    
    
    while(scanf("%d", &numCompetidor) != EOF){
    int ordemSaida[numCompetidor];   
    int ordemChegada[numCompetidor]; 
   
    for(int i = 0; i < numCompetidor; i++){
        scanf("%d", &ordemSaida[i]);
    } 

    
    for(int i = 0; i < numCompetidor; i++){
        scanf("%d", &ordemChegada[i]);
    } 


    
 
  ultrapassagens = 0;
  
      for(int i = 0; i < numCompetidor; i++){
      int tmp = ordemSaida[i];
        for(int j = 0; j < numCompetidor - 1; j++){
            if(ordemChegada[j] == tmp && i - j > 0){
                ultrapassagens += (i - j);
  }
          else if(ordemChegada[j] == tmp && i - j == 0  && i != 0 && ordemChegada[j + 1] == ordemSaida[i - 1]){
              ultrapassagens++;
      } 
    }
  }

printf("%d\n", ultrapassagens);

    }
    return 0;
  }