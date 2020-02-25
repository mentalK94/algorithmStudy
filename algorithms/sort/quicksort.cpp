// �� ���� �˰���
// ��� �ӵ� (N*logN) 
// �־� �ӵ� (N^2) -> �̹� ������ �Ǿ��ִ� ��� �־Ǽӵ��� ��Ÿ����. 
// �������� �������� ����� ���� ������ ���� -> 25, 30�࿡�� �ε�ȣ�� �ٲ��ָ� �ȴ�. 

#include <stdio.h>

int number = 10;
int data[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

void quickSort(int *data, int start, int end) {

	if(start >= end) { // ���Ұ� 1���� ��� 
		return;	
	}
	
	int key = start;
	int leftLink = start+1; // ���� ��ũ
	int rightLink = end; // ���� ��ũ
	int temp;
	
	while(leftLink <= rightLink) { // �������� ���� ���� 
	
		// ������ũ�� ���鼭 ��ũ ���� pivot���� ū ������ ���� 
		while(data[leftLink] >= data[key]) {
			leftLink++;
		} 
		
		// ������ũ�� ���鼭 ��ũ ���� pivot���� ���� ������ ���� 
		while(data[rightLink] <= data[key] && rightLink > start) {
			rightLink--;
		}
		
		// ������ ��� -> pivot�� ��ü 
		if(leftLink > rightLink) {
			temp = data[rightLink];
			data[rightLink] = data[key];
			data[key] = temp;
			
		} else { // �������� ������� 
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
