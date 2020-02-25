#include <stdio.h>

void printArr(int arr[], int size) {
	for(int i=0; i<size; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}

void selectionSort(int arr[], int size) {
	
	for(int i=0; i<size; i++) {
		
		int min = arr[i];
		int min_idx = i;
		int temp = 0;
		
		for(int j=i; j<size-1; j++) {
			if(min > arr[j]) { // 최소값 찾는 과정 
				min = arr[j];
				min_idx = j;
			}			
		}
		
		temp = arr[i];
		arr[i] = arr[min_idx];
		arr[min_idx] = temp;
		
		printArr(arr, size); 
	}
}

int main() {
	
	int arr[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9}; 
	selectionSort(arr, 10);
}
