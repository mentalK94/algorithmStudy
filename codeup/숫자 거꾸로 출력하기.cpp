/*
** ���� �Ųٷ� ����ϱ�.cpp
** 2020-02-27
*/

#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	
	queue<int> q;
	int number;
	
	cin >> number;
	
	if(number == 0) {
		q.push(number);
	}
	
	while(number!=0) {
		q.push(number%10);
		number /= 10;
	}
	
	while(!q.empty()) {
		cout << q.front();
		q.pop();
	}
	
	return 0;
	
}
