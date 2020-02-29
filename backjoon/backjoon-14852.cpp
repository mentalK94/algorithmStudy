/*
** 타일 채우기 3 
** backjoon-14852.cpp
** 2020-02-29
*/

#include <stdio.h>

long long int fiboArr[1000001][2];

long long int fibo(int x) {

	fiboArr[0][0] = 0;
	fiboArr[1][0] = 2;
	fiboArr[2][0] = 7;
	fiboArr[2][1] = 1;
	for (int i=3; i<=x; i++) {
		fiboArr[i][1] = (fiboArr[i-1][1] + fiboArr[i-3][0])%1000000007;
		fiboArr[i][0] = ((3*fiboArr[i-2][0] + 2*fiboArr[i-1][0]) + 2*fiboArr[i][1])%1000000007;
	}
	
	return fiboArr[x][0];
} 

int main(void) {
	
	int number;
	
	scanf("%d", &number);
	
	printf("%lld", fibo(number));
	return 0;
	
}
