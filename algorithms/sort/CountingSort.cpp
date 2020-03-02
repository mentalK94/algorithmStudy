// 계수 정렬 알고리즘
// 평균 속도 O(N) 
// 크기가 정해져 있는경우 매우 빠르게 정렬할 수 있다. 

#include <stdio.h>

int main(void) {
	
	int temp;
	int count[6] = {0};
	int array[30] = {
		1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
		3, 4, 4, 3, 5, 1, 2, 3, 5, 2,
		3, 1, 4, 3, 5, 1, 2, 1, 1, 1
	};
	
	for(int i=0; i<30; i++) {
		count[array[i]] += 1;
	}
	
	for(int i=1; i<=5; i++) {
	//	printf("%d ", count[i]);
		for(int j=0; j<count[i]; j++) {
			printf("%d ", i);
		}
		// printf("\n");
	}
	
	return 0;
}
