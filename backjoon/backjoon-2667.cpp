/*
** backjoon-2667.cpp
** 단지번호 붙이기 
** 2020-03-03
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool checked[25][25]={false};
vector<int> v;
char arr[25][25] = {'0'};
int cnt;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
 
void dfs(int x, int y, int size) {
	
	if(checked[x][y])
		return;
 	checked[x][y] = true;
 	cnt++;
	for(int i=0; i<4; i++) {
		int nx = x+dx[i];
		int ny = y+dy[i];
		if(0 <= nx && nx < size && 0 <= ny && ny < size) {
			if(arr[nx][ny] == '1')
				dfs(nx, ny, size);
		} 
	}
 	
}

int main(void) {
	
	int number;
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		for(int j=0; j<number; j++) {
			cin >> arr[i][j];
		}
	}
	
	for(int i=0; i<number; i++) {		
		for(int j=0; j<number; j++) {
			if(arr[i][j] == '1') {
				cnt = 0;	
				dfs(i, j, number);
				if(cnt != 0)
					v.push_back(cnt);							
			}									
		}
	}
	
	sort(v.begin(), v.end());
	
	cout << v.size() << endl;
	
	for(int i=0; i<v.size(); i++) {
		cout << v[i] << endl;
	}
	
	return 0;
}
