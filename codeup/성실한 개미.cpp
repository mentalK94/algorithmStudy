// ������ ���� 

#include <stdio.h>

int main() {
	
	int curX=2, curY=2;
	int arr[11][11] = {};
	
	for(int i=1; i<11; i++) {
		for(int j=1; j<11; j++) {
			scanf("%d ", &arr[i][j]);
		}
	}
	
	while(true) {
		
		if(arr[curX][curY] == 2) {
			arr[curX][curY]=9;
			break;
		}
		arr[curX][curY]=9;
		
		if(arr[curX][curY+1] != 1) { // �������� �շ��ִ� ���̸� 
			curY++;
		} else if(arr[curX+1][curY] != 1) { // �Ʒ����� �շ��ִ� ���̸�
			curX++;
		} else { // �Ѵ� �������
			break; 
		}
	}
	
	for(int i=1; i<11; i++) {
		for(int j=1; j<11; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}
