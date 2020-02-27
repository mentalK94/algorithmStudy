/*
** 천단위 구분기호.cpp
** 2020-02-27
*/

#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	
	queue<char> q;
	char number[270];
	int length;
	
	cin >> length;
	
	for(int i=0; i<length; i++){
		
		if((i-(length%3))%3==0 && i!=0) {
			q.push(',');	
		}

		cin >> number[i];
		
		q.push(number[i]);		
	}
	
	while(!q.empty()) {
		cout << q.front();
		q.pop();
	}
	
	return 0;
	
}
