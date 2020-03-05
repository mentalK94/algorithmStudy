/*
** backjoon-2739.cpp
** ±¸±¸´Ü 
** 2020-03-03
*/

#include <iostream>

using namespace std;

int main(void) {
	
	int n;
	
	cin >> n;
	
	for(int i=1; i<=9; i++) {
		cout << n << " * " << i << " = " << n*i << endl;
	} 

	return 0;
}
