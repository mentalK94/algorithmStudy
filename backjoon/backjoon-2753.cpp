/*
** backjoon-2753.cpp
** À±³â 
** 2020-03-03
*/

#include <iostream>

using namespace std;

int main(void) {
	
	int year;
	
	cin >> year;
	
	if(year%4==0) {
		if(year%100==0 && year%400!=0) {
			cout << 0;
		} else {
			cout << 1;	
		}		
	} else {
		cout << 0;
	}

	return 0;
}
