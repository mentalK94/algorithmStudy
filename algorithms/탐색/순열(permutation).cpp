#include <stdio.h>

int arr[] = {1,2,3,4,5};

void swap(int *a, int *b ){
	int tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

void print_arr(){
	for(int i=0; i < sizeof(arr)/sizeof(int); i++)
		printf("%d ", arr[i]);
	printf("\n");
}

void permutation(int n, int r){

	// Ż���������� r�� 0�� �Ǹ� ������ �� ��찡 �Ϸ�Ǿ����Ƿ� return�մϴ�.
	if( r == 0){
		print_arr();
		return;
	}

	// ���� ���� �ִ� n-1�� ��ġ�� ���ҿ�
	// ���� ���� �ִ� i�� ���Ҹ� �ٲ㼭
	// ��� �Լ��� �־��ݴϴ�.

	// 1-2-3�� ���� ������
	// 3(���� i)�� 3(���� n-1)�� �ٲߴϴ�.
	// �׷��� 3�� ���� �ڿ� �����̰�
	// 1��2�� ���� �ٲٴ� ��찡 ����Ƿ�
	// 1-2-3�� 2-1-3�� �����˴ϴ�.

	// ���� �ٽ�
	// 2(���� i)�� 3(���� n-1)�� �ٲߴϴ�.
	// �׷��� 2�� ���� �ڿ� �����̰�
	// 1��3�� ���� �ٲٴ� ��찡 ����Ƿ�
	// 1-3-2�� 3-1-2�� �����˴ϴ�.

	// ���ڰ� �� Ŀ���ų��ص� ���� ������ ����˴ϴ�.
	for(int i=n-1; i>=0; i--){
		swap(&arr[i], &arr[n-1]);
		permutation(n-1, r-1);
		// �Ʒ�ó�� �ٽ� swap������� �������� ��� ������ �� arr�� ��ȭ���Ե˴ϴ�.
		swap(&arr[i], &arr[n-1]);
	}


}

int main() {
	permutation(sizeof(arr)/sizeof(int), sizeof(arr)/sizeof(int));
	return 0;
}

