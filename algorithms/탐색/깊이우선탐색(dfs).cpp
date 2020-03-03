/*
** ±íÀÌ¿ì¼±Å½»ö(DFS).cpp
** 2020-02-27
*/

#include <iostream>
#include <vector>

using namespace std;

int number = 7;
bool checked[8];
vector<int> a[8];

void dfs(int x) {
	
	if(checked[x])
		return;
	checked[x] = true;
	cout << x << " ";
	for(int i=0; i<a[x].size(); i++) {
		if(checked[a[x][i]])
			continue;
		dfs(a[x][i]);
	}
}

int main(void) {
	
	a[1].push_back(2);
	a[1].push_back(3);
	
	a[2].push_back(1);
	a[2].push_back(3);
	a[2].push_back(4);
	a[2].push_back(5);
	
	a[3].push_back(1);
	a[3].push_back(2);
	a[3].push_back(6);
	a[3].push_back(7);
	
	a[4].push_back(2);
	a[4].push_back(5);
	
	a[5].push_back(2);
	a[5].push_back(4);
	
	a[6].push_back(3);
	a[6].push_back(7);
	
	a[7].push_back(3);
	a[7].push_back(6);
	
	dfs(5);
	
	return 0;
	
}
