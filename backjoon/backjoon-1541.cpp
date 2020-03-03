/*
** backjoon-1541.cpp
** 잃어버린 괄호 
** 2020-03-03
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;



int main(void) {
	
	vector<int> plusNumber;
	vector<int> minusNumber;
	int number = 0;
	
	string expression;
	
	cin >> expression; 
	
	for(int i=0; i<expression.size(); ) {
		int n=0;
		if(expression[i] != '-') { // '+' or 숫자일 때 			
			if(expression[i] == '+') {
				i++;
				continue;				
			}
			
			while(i<expression.size() && expression[i]-'0'>=0 && expression[i]-'0'<=9)  {
				n*=10;	
				n+=expression[i]-'0';
				i++;
			}
			plusNumber.push_back(n);					
			
		} else {
			i++;	
			while(i<expression.size())  {
				
				if(expression[i] == '-' || expression[i] == '+')
					i++;
				
				while(expression[i]-'0'>=0 && expression[i]-'0'<=9) {					
					n*=10;	
					n+=expression[i]-'0';
					i++;
				} 
				minusNumber.push_back(n);
				n=0;				
			}
			
		}		
	}
	
	for(int i=0; i<plusNumber.size(); i++) {
		number += plusNumber[i];
	}
	
	for(int i=0; i<minusNumber.size(); i++) {
		number -= minusNumber[i];
	}
	cout << number;
	
	return 0;
}
