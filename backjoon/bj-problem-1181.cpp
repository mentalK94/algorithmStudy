// backjoon - �ܾ� ����
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <string>

using namespace std;

bool compare(string a, string b) {
	
	// ���̰� ª�� ���� �켱 
	if(a.length() < b.length()) {
		return 1;
	} else if(a.length() > b.length()) {
		return 0;
	} else { // ���̰� ���� ��� 
		return a < b; // ���� ������ ���� 
	}
	
}

int main(void) {
	
	int number; // �ܾ� ����
	string words[20000]; // �ܾ� 	
	
	scanf("%d", &number);
	
	for(int i=0; i<number; i++) {
		cin >> words[i];
	}
	
	// �ܾ� ���� �˰���
	sort(words, words+number, compare);
	
	for(int i=0; i<number; i++) {
		if(i>0 && words[i] == words[i-1])
			continue;
		cout << words[i] << endl;
	}
	
	return 0;
}
