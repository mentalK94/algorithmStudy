/*
** 타일 채우기 
** backjoon-2133.cpp
** 2020-02-29
*/

#include <stdio.h>

int fiboArr[30];

int fibo(int x) {
	if( x== 0)
		return 1;
	if( x == 1)
		return 0;
	if( x == 2)
		return 3;

	if(fiboArr[x] != 0) return fiboArr[x];
	int result = 3 * fibo(x-2);
	for(int i=3; i<=x; i++) {
		if(i%2==0) {
			result += 2*fibo(x-i);
		}
	}
	
	return fiboArr[x] = result; 
		
} 

int main(void) {
	
	int number;
	
	scanf("%d", &number);
	
	printf("%d", fibo(number));
	return 0;
	
}
