/*
** 너비 우선탐색(BFS) - 구현하여라 
*/

#include <iostream> 
#include <queue>
#include <vector>

using namespace std;
vector<int> a[8];
bool checked[8] = {false};

// 1. 노드를 방문한다 - 해당 노드를 큐에 넣고 방문처리 한다.
// 2. 방문한 노드의 인접한 노드 중 방문처리 되지 않은 노드를 큐에 넣는다. 
void bfs(int start) {
	
	queue<int> q;	
	q.push(start);
	checked[start] = true;	
	
	while(!q.empty()) {
		int x = q.front();
		cout << x << " "; 
		for(int i=0; i<a[x].size(); i++) {
			if(checked[a[x][i]]) 
				continue;
			checked[a[x][i]] = true;
			q.push(a[x][i]);
		}
		q.pop();
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
	
	bfs(5);
	
	return 0;
}
