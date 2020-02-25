#include <stdio.h>

int main() {
	
	int h, w, n, l, d, x, y;
	int arr[101][101]={};
	
	scanf("%d %d", &h, &w);
	scanf("%d", &n);
	
	for(int i=0; i<n; i++)  {
		
		scanf("%d %d %d %d", &l, &d, &x, &y);
		
		if(d==0) { // 가로인 경우 
			for(int j=y; j<y+l; j++) {
				arr[x][j] = 1;
			}
		} else { // 세로인 경우 
			for(int j=x; j<x+l; j++) {
				arr[j][y] = 1;
			}
		}
	}
	
	for(int i=1; i<=h; i++) {
		for(int j=1; j<=w; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}
