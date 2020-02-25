// 퀵 정렬 알고리즘
// 평균 속도 (N*logN) 
// 최악 속도 (N^2) -> 이미 정렬이 되어있는 경우 최악속도를 나타낸다. 
// 오름차순 내림차순 변경시 가장 간편한 정렬 -> 25, 30행에서 부등호만 바꿔주면 된다. 

#include <stdio.h>

int number = 10;
int data[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

void quickSort(int *data, int start, int end) {

	if(start >= end) { // 원소가 1개인 경우 
		return;	
	}
	
	int key = start;
	int leftLink = start+1; // 좌측 링크
	int rightLink = end; // 우측 링크
	int temp;
	
	while(leftLink <= rightLink) { // 엇갈릴때 까지 루프 
	
		// 좌측링크가 돌면서 링크 값이 pivot보다 큰 값에서 정지 
		while(data[leftLink] >= data[key]) {
			leftLink++;
		} 
		
		// 우측링크가 돌면서 링크 값이 pivot보다 작은 값에서 정지 
		while(data[rightLink] <= data[key] && rightLink > start) {
			rightLink--;
		}
		
		// 엇갈린 경우 -> pivot과 교체 
		if(leftLink > rightLink) {
			temp = data[rightLink];
			data[rightLink] = data[key];
			data[key] = temp;
			
		} else { // 엇갈리지 않은경우 
			temp = data[rightLink];
			data[rightLink] = data[leftLink];
			data[leftLink] = temp;			
		}			
	}
	
	quickSort(data, start, rightLink-1);
	quickSort(data, rightLink+1, end);
	
}

int main(void) {
	quickSort(data, 0, number-1);
	for(int i=0; i<number; i++) {
		printf("%d ", data[i]);
	}
	
	return 0;
}
