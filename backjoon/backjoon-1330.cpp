/*
** backjoon-1330.cpp
** �� �� ���ϱ� 
** 2020-03-03
*/

#include <iostream>

using namespace std;

string compare(int a, int b) {
	if(a>b) {
		return ">";	
	} else if (a==b) {
		return "==";
	} else {
		return "<";
	}
}

int main(void) {
	
	int a, b;
	cin >> a >> b;
	
	cout << compare(a, b);
}
