/*
** backjoon-2178.cpp
** ¹Ì·Î Å½»ö 
** 2020-03-04
*/

#include <iostream>
#include <stdio.h>
#include <queue>

using namespace std;

int arr[101][101] = {0};
int checked[101][101] = {0};
int cnt=0;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

void bfs(int x, int y, int w, int h) {
	
	queue<pair<int, int> > q;
	q.push(pair<int, int> (x, y));
	checked[x][y] = true;
	
	while(!q.empty()) {			
	
		int curX = q.front().first;
		int curY = q.front().second; 

		for(int i=0; i<4; i++) {
			
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];			
			
			if(nextX > 0 && nextX <= h && nextY > 0 && nextY <= w) {
				if(arr[nextX][nextY] == 1 && checked[nextX][nextY] == 0) {
					q.push(pair<int, int> (nextX, nextY));
					checked[nextX][nextY] = checked[curX][curY] + 1;
				}
			}
		}
		q.pop();
	}
	 
}

int main(void) {

 	int n, m;
 	
 	scanf("%d %d", &n, &m);
 	
 	for(int i=1; i<=n; i++) { 		
 		for(int j=1; j<=m; j++) {
 			scanf("%1d", &arr[i][j]);		
		}
	}
 	
 	bfs(1, 1, m, n);
 	
 	cout << checked[n][m] << endl;
 	
	return 0;
	
}
