/*
** backjoon-10817.cpp
** �� �� 
** 2020-03-03
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {
	
	int a[3];
	
	cin >> a[0] >> a[1] >> a[2];

	sort(a, a+3);
	
	cout << a[1];

	return 0;
}
