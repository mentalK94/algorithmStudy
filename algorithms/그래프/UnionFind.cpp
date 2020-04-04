/*
** UnionFind.cpp 
** 2020-04-04
*/

#include <stdio.h>

int getParent(int arr[], int x) {
	if(x == arr[x]) return x;
	return getParent(arr, arr[x]);
}

int unionParent(int arr[], int x, int y) {
	x = getParent(arr, x);
	y = getParent(arr, y);
	if(x<y) arr[y] = x;
	else arr[x] = y;
}

int findParent(int arr[], int x, int y) {
	int a = getParent(arr, x);
	int b = getParent(arr, y);
	if(a == b) return 1;
	return 0;
}

int main(void) {
	
	
	int parent[11];
	for(int i=1; i<=10; i++) {
		parent[i] = i;
	}
	unionParent(parent, 1, 2);
	unionParent(parent, 2, 3);
	unionParent(parent, 3, 4);
	
	unionParent(parent, 5, 6);
	unionParent(parent, 6, 7);
	unionParent(parent, 7, 8);
	
	printf("%d", getParent(parent, 4));
	printf("%d", getParent(parent, 5));
	unionParent(parent, 1, 8);
	printf("%d", getParent(parent, 5));
	printf("1과 5는 연결되어 있나요? %d\n", findParent(parent, 1, 5));
	
	return 0;
	
}
