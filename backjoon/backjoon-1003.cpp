/*
** backjoon-1003.cpp
** 피보나치 함수 
** 2020-03-13
*/

#include <iostream>
#include <cstring>
#include <cmath>
#define CACHE_SIZE 91

using namespace std;

long long int cache[40];
int zeroCnt=0;
int oneCnt=0;

long long int fibonacci(int x) {

	if(x==0) {		
		zeroCnt++;
		return 0;		
	}
		
	if(x==1) {
		oneCnt++; 
		return 1;		
	}
		
	if(cache[x] != -1)
		return cache[x];
	else
		return cache[x]=fibonacci(x-1) + fibonacci(x-2);
		
}

int main(void) {

 	int t, n;	
 	
 	cin >> t;
 	
 	for(int i=0; i<t; i++) { 
 		cin >> n;
 		memset(cache, -1, sizeof(cache)); // cache배열 -1로 초기화 
 		fibonacci(n);
 		cout << zeroCnt << " " << oneCnt << endl;
 		zeroCnt=0;
 		oneCnt=0;
	}
 	
	return 0;
	
}
