#include <stdio.h>

int main(void) {
	
	int arr[1001];
	int size, temp;
	
	scanf("%d", &size); // ���� ���� �Է� 
	for(int i=0; i<size; i++) {
		scanf("%d", &arr[i]); // ������ŭ �� �Է� 
	}
	
	for(int i=1; i<size; i++) {
		for(int j=i; j>0; j--) {
			if(arr[j] < arr[j-1]) {
				temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;		
			}
		}
	}
	
	for(int i=0; i<size; i++) {
		printf("%d\n", arr[i]);
	}
}
