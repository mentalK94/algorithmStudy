/*
** backjoon-2748.cpp
** 피보나치 수 2 
** 2020-03-13
*/

#include <iostream>
#include <cstring>
#include <cmath>
#define CACHE_SIZE 91

using namespace std;

long long int cache[CACHE_SIZE];

long long int fibonacci(int x) {

	if(x==0)
		return cache[0] = 0;
	if(x==1)
		return cache[1] = 1;
	if(cache[x] != -1)
		return cache[x];
	else
		return cache[x]=fibonacci(x-1) + fibonacci(x-2);
		
}

int main(void) {

 	int n;
	long long int answer;
 	
 	cin >> n;
 	
 	memset(cache, -1, sizeof(cache)); // cache배열 -1로 초기화 
 	answer = fibonacci(n);
 	cout << answer << endl;
	return 0;
	
}
