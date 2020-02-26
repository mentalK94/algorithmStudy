// backjoon - 단어 정렬
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <string>

using namespace std;

bool compare(string a, string b) {
	
	// 길이가 짧은 것이 우선 
	if(a.length() < b.length()) {
		return 1;
	} else if(a.length() > b.length()) {
		return 0;
	} else { // 길이가 같은 경우 
		return a < b; // 사전 순으로 정렬 
	}
	
}

int main(void) {
	
	int number; // 단어 개수
	string words[20000]; // 단어 	
	
	scanf("%d", &number);
	
	for(int i=0; i<number; i++) {
		cin >> words[i];
	}
	
	// 단어 정렬 알고리즘
	sort(words, words+number, compare);
	
	for(int i=0; i<number; i++) {
		if(i>0 && words[i] == words[i-1])
			continue;
		cout << words[i] << endl;
	}
	
	return 0;
}
