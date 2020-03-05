/*
** backjoon-1012.cpp
** 유기농 배추 
** 2020-03-04
*/

#include <iostream>
#include <cstring>

using namespace std;

int arr[50][50] = {0};
bool checked[50][50] = {false};
int cnt=0;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, 1, -1};


void dfs(int x, int y, int w, int h) {
	
	if(checked[x][y] || arr[x][y] != 1) return;
	checked[x][y] = true;
	
	for(int i=0; i<4; i++) {
		int nx = x+dx[i];
		int ny = y+dy[i];
		
		if(nx>=0 && nx<h && ny>=0 && ny<w) {
			dfs(nx, ny, w, h);
		}
	}
	
}

int main(void) {

 	int n, w, h, k; // n:테스트 수, w:가로, h:세로, k:배추의 개수 
 	int x, y;
 	
 	cin >> n; 	
 	
 	for(int i=0; i<n; i++) {
 		cin >> w >> h >> k;
	 	
	 	cnt = 0;
	 	memset(arr, 0, sizeof(arr));
	 	memset(checked, false, sizeof(checked));
	 	
	 	for(int j=0; j<k; j++) {
	 		cin >> x >> y;
			arr[y][x] = 1;	
		}				
	 	
//	 	for(int a=0; a<h; a++) {
//	 		for(int b=0; b<w; b++) {
//	 			cout << arr[a][b] << " ";			 			
//			}	
//			cout << endl;
//		}	
	 	
	 	for(int a=0; a<h; a++) {
	 		for(int b=0; b<w; b++) {
	 			if(arr[a][b] == 1 && checked[a][b] == false) {
					dfs(a, b, w, h);
					cnt++;	
				}	 				 			
			}	
		}
	 	cout << cnt << endl;
	 	 	
 	}
 	
	return 0;
	
}
