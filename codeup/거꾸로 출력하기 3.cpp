/*
** 거꾸로 출력하기 3.cpp
** 2020-02-27
*/

#include <iostream>
#include <stack>

using namespace std;

int main(void) {
	
	int number;
	stack<int> st;
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		int data;
		cin >> data;
		st.push(data);
	}
	
	while(!st.empty()) {
		cout << st.top() << ' ';
		st.pop();
	}
	return 0;
	
}
