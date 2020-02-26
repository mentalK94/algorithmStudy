// backjoon - 시리얼 번호 
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <string>

using namespace std;

int getSum(string a) {
	
	int length = a.length();
	int sum = 0;
	for(int i=0; i<length; i++) {
		if(a[i]-'0'<= 9 && a[i]-'0' > 0) {
			sum += a[i]-'0';
		}
	}
	
	return sum;
}

bool compare(string a, string b) {
	
	// 짧은 것이 우선순위 
	if(a.length() < b.length()) {
		return 1;
	} else if(a.length() > b.length()) {
		return 0;
	} else { // 시리얼 넘버의 길이가 같은 경우 
		int sumA = getSum(a);
		int sumB = getSum(b);
		if(sumA != sumB) {
			return sumA < sumB;
		} else {
			return a < b;
		}
	}
}


int main(void) {
	
	int number;
	string serial[1000]; // 단어 
	
	scanf("%d", &number);
	
	for(int i=0; i<number; i++) {
		cin >> serial[i];
	}
	
	sort(serial, serial+number, compare);
	
	for(int i=0; i<number; i++) {
		cout << serial[i] << endl;
	}
	
	return 0;
}
