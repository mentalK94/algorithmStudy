/*
** programmers-피보나치 수.cpp
** 2020-05-16
*/

#include <string>
#include <iostream>
#include <vector>

using namespace std;

int cache[100001] = {0,};

int fibonacci(int n) {
	if(n == 0) {
		return 0;
	}
	if(n == 1) {
		return 1;
	}
	if(n == 2) {
		return 1;
	}
	
	if(cache[n] != 0) {
		return cache[n];
	}
	return cache[n] = fibonacci(n-1)%1234567 + fibonacci(n-2)%1234567;
} 

int solution(int n) {
    int answer = 0;
    
    answer = fibonacci(n)%1234567;
    
    cout << answer << endl;
    return answer;
}

int main(void) {
	solution(32505);
	return 0;
}

