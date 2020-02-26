// codeup - 데이터 정렬(large) 
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	
	int number;
	int arr[10000];
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr+number);
	
	for(int i=0; i<number; i++) {
		cout << arr[i] << endl;
	}
	
	return 0;
}
