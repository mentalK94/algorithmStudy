/*
** heapSort.cpp
** 2020-02-26
*/

#include <stdio.h>

int sorted[10];

void heapSort(int heap[], int size, int sortedCounter) {
	
//	for(int i=0; i<size; i++) {
//		printf("%d ", heap[i]);
//	}
//	printf("\n");
	if(size >= 1) {
		
		// heapify
		for(int i=1; i<size; i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			} while(c != 0);
		}
		
//		for(int i=0; i<size; i++) {
//			printf("%d ", heap[i]);
//		}
//		printf("\n");
		
		// max°ª Ã£±â
		int temp = heap[size-1];
		heap[size-1] = heap[0];
		heap[0] = temp;
		
//		sorted[sortedCounter] = heap[size-1];
//		for(int i=0; i<9; i++) {
//			printf("%d ", sorted[i]);
//		}
//		printf("\n");
		
		heapSort(heap, size-1, sortedCounter+1);	
	}
}


int main(void) {
	int a[10] = {6, 4, 8, 2, 1, 10, 7, 9, 3};
	heapSort(a, 9, 0);
	
	for(int i=0; i<9; i++) {
		printf("%d ", a[i]);
	}
	return 0;
}
