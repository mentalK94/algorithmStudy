/*
** 30 
** backjoon-10610.cpp
** 2020-03-03
*/

#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
	return a>b;
}

int main(void) {
	
	int input, length=0;
	int arr[5] = {0};
	
	cin >> input;
	
	for(int i=0; input!=0; i++) {
		arr[i] = input%10;
		input /= 10;
		length++;
	}
	
 	sort(arr, arr+length, compare);
	 
	if(arr[length-1] != 0) {
		cout << -1;
		return 0;
	}
	
	int number = 0;
	for(int i=0; i<length; i++) {
		number += arr[i];
	}
	
	if(number % 3 != 0) {
		cout << -1;
		return 0;
	}
		
	for(int i=0; i<length; i++) {
		cout << arr[i];
	}
}
