/*
** 시험감독.cpp
** 2020-04-13 
*/

#include <iostream>

using namespace std;

int main(void) {
	
	long long answer = 0;
	int cnt;
	int n; // 시험장의 개수
	int participants[1000000]; // 각 시험장에 존재하는 응시자 수
	int b; // b : 총감독관이 한 시험장에서 감시할 수 있는 응시자 수
	int c; // c : 부감독관이 감시할 수 있는 응시자의 수 
	
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


