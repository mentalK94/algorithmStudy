// codeup - 내림차순 정렬 
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <vector>

using namespace std;

bool compare(int a, int b) {
	return a>b;
}

int main(void) {
	
	int number;
	int arr[100];
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr+number, compare);
	
	for(int i=0; i<number; i++) {
		cout << arr[i] << " ";
	}
	
	return 0;
}
