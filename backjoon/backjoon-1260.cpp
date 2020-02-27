/*
** backjoon-1260.cpp
** DFS와 BFS 
** 2020-02-27
*/

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

bool dfsChecked[1001];
bool bfsChecked[1001];
vector<int> a[1001];

void dfs(int x) {
	
	if(dfsChecked[x]) return;
	
	cout << x << " ";

	dfsChecked[x] = true;
	for(int i=0; i<a[x].size(); i++) {
		sort(a[x].begin(), a[x].end());
		int y = a[x][i];
		dfs(y);
	}
}

void bfs(int x) {
	
	queue<int> q;
	q.push(x);
	bfsChecked[x] = true;
	
	while(!q.empty()) {
		int x = q.front();
		q.pop();
		cout << x << " ";
		
		for(int i=0; i<a[x].size(); i++) {
			sort(a[x].begin(), a[x].end());
			int y = a[x][i];
			if(!bfsChecked[y]) {
				q.push(y);
				bfsChecked[y] = true;
			}
		}
	}
} 

int main(void) {
	
	int n, m, v;
	
	cin >> n; // 정점 개수 
	cin >> m; // 간선 개수 
	cin >> v; // 시작 정점번호 
	
	for(int i=0; i<m; i++) {
		int nNumber, mNumber;
		cin >> nNumber;
		cin >> mNumber;
		a[nNumber].push_back(mNumber);
		a[mNumber].push_back(nNumber);
	}

	// DFS 결과출력
	dfs(v);
	
	cout << endl;
	
	// BFS 결과출력 
	bfs(v);
	
	return 0;
	
}
