/*
** ATM 
** backjoon-11399.cpp
** 2020-03-02
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {
	
	int n, time=0;
	int p[2][1000] = {0};
	
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> p[0][i];
	}
	
	sort(p[0], p[0]+n);
	
	p[1][0] = p[0][0];	
	
	for(int i=1; i<n; i++) {
		p[1][i] = p[0][i]+p[1][i-1];		
	}
	
	for(int i=0; i<n; i++) {
		time += p[1][i];
	}
	
	cout << time << endl;
}
