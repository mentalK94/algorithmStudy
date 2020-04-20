/*
** 조합코드.cpp
*/

#include <iostream> 
#include <queue>
#include <vector>


int main(void){

    int i, j;
    char arr[4] = { 'a', 'b', 'c', 'd' };
    int n = 4;

    for (i = 0; i < (1 << (n)); i++){
        for (j = 0; j < n; j++){
            if (i & (1 << j)){
                printf("%c ", arr[j]);
            }
        }
        printf("\n");
    }
}

