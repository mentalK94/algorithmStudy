/*
** ���谨��.cpp
** 2020-04-13 
*/

#include <iostream>

using namespace std;

int main(void) {
	
	long long answer = 0;
	int cnt;
	int n; // �������� ����
	int participants[1000000]; // �� �����忡 �����ϴ� ������ ��
	int b; // b : �Ѱ������� �� �����忡�� ������ �� �ִ� ������ ��
	int c; // c : �ΰ������� ������ �� �ִ� �������� �� 
	
	cin >> n;	
	
	for(int i=0; i<n; i++) {
		cin >> participants[i];
	}
	
	cin >> b;
	cin >> c; 
	
	for(int i=0; i<n; i++) {
		cnt = participants[i];
		cnt-=b;
		answer++;
		if(cnt < 0)
			continue;
		
		if(cnt%c==0)
			answer+=(cnt/c);
		else answer+=(cnt/c)+1;
	}

	cout << answer << endl;
	return 0;
}


