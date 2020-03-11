/*
** backjoon-9095.cpp
** 1, 2, 3¥ı«œ±‚ 
** 2020-03-11
*/

#include <iostream>

using namespace std;

int oneTothreeAdd(int k) {
	if(k==1) { return 1; }
	if(k==2) { return 2; }
	if(k==3) { return 4; }
	
	return oneTothreeAdd(k-1)+oneTothreeAdd(k-2)+oneTothreeAdd(k-3);
}

int main(void) {

	int n, k;
	
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> k;
		int answer = oneTothreeAdd(k);
		cout << answer << endl;
	}

	return 0;
	
}
