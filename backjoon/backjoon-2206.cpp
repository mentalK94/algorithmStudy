/*
** backjoon-2206.cpp
** 벽 부수고 이동하기 
** 2020-03-11
*/

#include <iostream>
#include <stdio.h>
#include <queue>
#include <tuple>

int checked[1001][1001][2] = {0};
int a[1001][1001];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int x, y, crashed;

using namespace std;

void bfs(int startX, int startY, int endX, int endY) {
	
	queue<tuple<int, int, int> > q;
	q.push(tuple<int, int, int> (startX, startY, 0));
	checked[startX][startY][crashed] = 1;
	
	while(!q.empty()) {
		
		tie(x, y, crashed) = q.front();
		q.pop();
		
		if(x == endX && y == endY) {
			cout << checked[x][y][crashed] << endl;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		
			if(nx>0 && nx<=endX && ny>0 && ny<=endY) {
				if(a[nx][ny] == 0 && checked[nx][ny][crashed] == 0) {
					q.push(make_tuple(nx, ny, crashed));
					checked[nx][ny][crashed] += (checked[x][y][crashed]+1);
				} else if(a[nx][ny] == 0) {
					if(crashed == 1) continue;
					checked[nx][ny][crashed+1] = checked[x][y][crashed]+1;
					q.push(make_tuple(nx, ny, crashed+1));
					
				}
			}
		}	
	}
	
	cout << -1 << endl;
	return;
}

int main(void) {

	int n, m;
	
	cin >> n >> m;
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=m; j++) {			
			scanf("%1d", &a[i][j]);
		}	
	}
	
	bfs(1, 1, n, m);

	return 0;
	
}
