/*
** 다이나믹 프로그래밍-피보나치수열.cpp 
** 2020-02-29
*/

#include <stdio.h>

int fiboArr[100];

int fibo(int x) {
	
	if(x == 1)
		return 1;
	if(x == 2) 
		return 1;
	if(fiboArr[x] != 0) return fiboArr[x];
	return fiboArr[x] = fibo(x-1) + fibo(x-2);
		
} 

int main(void) {
	
	printf("%lld ", fibo(50));
	return 0;
	
}
