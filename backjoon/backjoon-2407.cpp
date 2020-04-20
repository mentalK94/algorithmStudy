/*
** backjoon-2407.cpp
** а╤гу 
** 2020-04-20
*/

#include <iostream>
#include <stdio.h>
#include <queue>

using namespace std;

int k[100] = {0,};
int t[100] = {0,};

long long int combination(int n, int m) {
		
	long long int answer = 1;
	int idx;
	int size = m;
		
	
	for(idx=0; idx<size; idx++) {
		
		k[idx] = n;
		t[idx] = m;
		
		n--;
		m--;
		
		for(int i=0; i<=idx; i++) {
			
			if(k[i] == 0) { continue; }
						
			for(int j=0; j<=idx; j++) {
				if(t[j] == 0 || t[j] == 1) { continue; }
				if(k[i]%t[j] == 0) {
					k[i] /= t[j];
					t[j] = 0;
				}	
			}
		}

	}
	
	for(int i=0; i<size; i++) {
			
		if(k[i] == 0) { continue; }
		answer *= k[i];
		for(int j=0; j<size; j++) {
			if(t[j] == 0 || t[j] == 1) { continue; }
			if(answer % t[j] == 0) {
				answer /= t[j];
				t[j] = 0;
			}
		}
	}
	
	return answer;
	 
}

int main(void) {

 	int n, m;
	long long int answer=0;
 	
 	scanf("%d %d", &n, &m);
 	
 	answer = combination(n, m);
 	cout << answer << endl;
 	
	return 0;
	
}
