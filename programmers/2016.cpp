/*
** programmers-2016.cpp
** 2020-02-27
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* answer = (char*)malloc(sizeof(char)*3);
    int days[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int day = 0;
    
    if(a != 1) {
        for(int i=0; i<a-1; i++) {
        day += days[i];
        printf("%d\n", day);
      }
    } 
    

    day = day+b+4;
    printf("%d\n", day);
    day = day%7;
    printf("%d\n", day);
        
    switch(day) {
        case 0:{
            answer = "SUN";
            break;
        }
        case 1: {
            answer = "MON";
            break;
        }
        case 2: {
            answer = "TUE";
            break;
        }
        case 3: {
            answer = "WED";
            break;
        }
        case 4: {
            answer = "THU";
            break;
        }
        case 5: {
            answer = "FRI";
            break;
        }
        case 6: {
            answer = "SAT";
            break;
        }
    }
	
	printf("%s", answer);    
    return answer;
}

int main(void) {
	
	solution(9, 24);
	return 0;
}

