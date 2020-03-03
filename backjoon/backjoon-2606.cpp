/*
** backjoon-2606.cpp
** 바이러스 
** 2020-03-03
*/

#include <iostream>
#include <vector>

using namespace std;

bool checked[101]={false};
vector<int> v[101];
int count=0;

void dfs(int x) {
	
	if(checked[x]) return;
	checked[x] = true;
	count++;

	for(int i=0; i<v[x].size(); i++) {
		dfs(v[x][i]);
	}
 	
}

int main(void) {
	
	int computerNumber, connectNumber;
	int x, y;
	
	cin >> computerNumber;
	cin >> connectNumber;
	
	for(int i=0; i<connectNumber; i++) {
		cin >> x >> y;
		
		v[x].push_back(y);
		v[y].push_back(x);
	}
	
	dfs(1);
	
	cout << count-1;
	return 0;
}
