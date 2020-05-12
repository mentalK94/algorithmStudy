/*
** programmers-두 정수 사이의 합.cpp
** 2020-05-12
*/

#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    int min, max;
    
    if(a<b) {
    	min = a;
    	max = b;
	} else if(a>b) {
		min = b;
		max = a;
	} else {
		return a;
	}
	
	for(int i=min; i<=max; i++) {
		answer += min;
	}
    
    
    return answer;
}
