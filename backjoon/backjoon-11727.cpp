/*
** 2°øn ≈∏¿œ∏µ 2
** backjoon-11727.cpp
** 2020-02-29
*/

#include <stdio.h>

int fiboArr[1001];

int fibo(int x) {
	
	if(x == 1)
		return 1;
	if(x == 2) 
		return 3;
	if(fiboArr[x] != 0) return fiboArr[x];
	return fiboArr[x] = (fibo(x-1) + 2*fibo(x-2)) % 10007;
		
} 

int main(void) {
	
	int number;
	
	scanf("%d", &number);
	
	printf("%d", fibo(number));
	return 0;
	
}
