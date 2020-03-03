/*
** backjoon-2588.cpp
** °ö¼À 
** 2020-03-03
*/

#include <iostream>

using namespace std;

void multiple(int a, int b) {
	
	int y = b;
	int one = y%10;
	y /= 10;
	int tens = y%10;
	y /= 10;
	int hundreds = y%10;
	
	cout << a*one << endl;
	cout << a*tens << endl;
	cout << a*hundreds << endl;
	cout << a*b << endl;
}

int main(void) {
	
	int a, b;
	cin >> a >> b;
	
	multiple(a, b);
}
