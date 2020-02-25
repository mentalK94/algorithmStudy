#include <stdio.h>

void printArr(int arr[], int size) {
	for(int i=0; i<size; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}

void insertionSort(int arr[], int size) {
	
	int temp;
	
	for(int i=1; i<size; i++) {			
		
		for(int j=i; j>0; j--) {
			if(arr[j] < arr[j-1]) {
				temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
			
		}
		
		printArr(arr, size);
	}
}

int main() {
	int arr[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9}; 
	insertionSort(arr, 10);
}
