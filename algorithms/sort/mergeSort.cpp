/*
** mergeSort.cpp
** 2020-02-26
*/

#include <stdio.h>

int sorted[10];

void merge(int arr[], int start, int mid, int end) {
	
	int i = start;
	int j = mid+1;
	int k = start;
	
	while(i <= mid && j <= end) {
		if(arr[i] < arr[j]) {
			sorted[k] = arr[i];
			i++;
		} else {
			sorted[k] = arr[j];
			j++;
		}
		k++;
	}
	
	if(i > mid) {
		for(int t=j; t<=end; t++) {
			sorted[k] = arr[t];
			k++;			
		}
	} else {
		for(int t=i; t<=mid; t++) {
			sorted[k] = arr[t];
			k++;			
		}
	}
	
	for(int t=start; t<=end; t++) {
		arr[t] = sorted[t];
	}
}

void mergeSort(int arr[], int start, int end) {
	if(start < end) {
		mergeSort(arr, start, (start+end)/2);
		mergeSort(arr, (start+end)/2+1, end);
		merge(arr, start, (start+end)/2, end);		
	}
}

int main(void) {
	int a[10] = {6, 4, 8, 2, 1, 10, 7, 9, 3};
	mergeSort(a, 0, 8);
	
	for(int i=0; i<9; i++) {
		printf("%d ", a[i]);
	}
	return 0;
}
