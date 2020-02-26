// codeup - 데이터 재정렬 
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <vector>

int sorted[50000];
int indexed[50000];

using namespace std;

bool compare(int a, int b) {
	return a<b;
}

int binarySearch(int sortedArr[], int search, int start, int end) {
	
	int mid = (start+end)/2;
	
	if(search == sortedArr[mid]) {
		return mid;	
	} else if(search < sortedArr[mid]) {
		binarySearch(sortedArr, search, start, mid-1);
	} else if(search > sortedArr[mid]) {
		binarySearch(sortedArr, search, mid+1, end);
	} 
	
}

int main(void) {
	
	int number;
	int arr[50000];
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		cin >> arr[i];
		sorted[i] = arr[i];
	}
	
	sort(sorted, sorted+number, compare);

//  O(n^2)으로 인해 시간초과...	
//	for(int i=0; i<number; i++) {
//		for(int j=0; j<number; j++) {
//			if(arr[i] == sorted[j]) {
//				cout << j << " ";
//			}
//		}
//	}

//  2진 탐색기법 사용
	for(int i=0; i<number; i++) {
		indexed[i] = binarySearch(sorted, arr[i], 0, number-1);
	}
	
	for(int i=0; i<number; i++) {
		cout << indexed[i] << " ";
	}
	
	return 0;
}
