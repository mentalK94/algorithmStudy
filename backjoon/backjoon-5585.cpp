/*
** °Å½º¸§µ· 
** backjoon-5585.cpp
** 2020-03-02
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {
	
	int money[6]={500, 100, 50,
					10, 5, 1};
					
	int sendMoney, number = 0;
	
	cin >> sendMoney;
	int receiveMoney = 1000-sendMoney;
	
	for(int i=0; i<6; i++) {
					
		while(true) {
			if(receiveMoney < money[i]) 
				break;	
			receiveMoney -= money[i];
			number++;
		}
	}
	
	cout << number;
	return 0;
}
