/*
** �ʺ� �켱Ž��(BFS) - �����Ͽ��� 
*/

#include <iostream> 
#include <queue>
#include <vector>

using namespace std;
vector<int> a[8];
bool checked[8] = {false};

// 1. ��带 �湮�Ѵ� - �ش� ��带 ť�� �ְ� �湮ó�� �Ѵ�.
// 2. �湮�� ����� ������ ��� �� �湮ó�� ���� ���� ��带 ť�� �ִ´�. 
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
