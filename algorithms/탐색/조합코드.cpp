/*
** 조합코드.cpp
*/

#include <iostream> 

int main(void){

    int i, j;
    char arr[4] = { 'a', 'b', 'c', 'd' };
    int n = 4;

    for (i = 0; i < (1 << (n)); i++){
        for (j = 0; j < n; j++){
//        	printf("i : %d\n", i);
//        	printf("(1 << j) : %d\n", (1 << j));
            if (i & (1 << j)){
            	
                printf("%c", arr[j]);
            }
        }
        printf("\n");
    }
}

