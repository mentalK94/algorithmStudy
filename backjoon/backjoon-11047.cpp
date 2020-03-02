/*
** µ¿Àü 0 
** backjoon-11047.cpp
** 2020-03-02
*/

#include <iostream>

using namespace std;

int main(void) {
	
	int n, k, count=0;
	int money[10];
	
	cin >> n >> k;
	
	for(int i=0; i<n; i++) {
		cin >> money[i];
	}
	
	for (int i=n-1; i>=0; i--) {
		
		while(true) {
			if(k<money[i]) 
				break;
			
			k -= money[i];
			count++;
		}
	}
	
	cout << count << endl;
}
