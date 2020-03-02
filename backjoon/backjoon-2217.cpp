/*
** 로프 
** backjoon-2217.cpp
** 2020-03-02
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	
	vector<int> v;
	int n, w;
	
	cin >> n; // 로프의 갯수 	
	
	for(int i=0; i<n; i++) {
		cin >> w;
		v.push_back(w);
	}
	
	sort(v.begin(), v.end());
	
	for(int i=0; i<n; i++) {
		v[i]=v[i]*(n-i);
		
	}
	
	sort(v.begin(), v.end());
	
	cout << v[n-1] << endl;
	return 0;
}
