/*
** Å« ¼ö »¬¼À.cpp
** 2020-02-27
*/

#include <iostream>
#include <stack>

using namespace std;

int main(void) {
	
	stack<int> st;
	string a;
	string b;
	int aPointer, bPointer;
	bool tens = false;
	
	cin >> a;
	cin >> b;
	
	aPointer = a.length()-1;
	bPointer = b.length()-1;
	
	while(aPointer >= 0 && bPointer >= 0) {
		int value;
		int aData = a[aPointer] - '0';
		int bData = b[bPointer] - '0';
		
		value = aData + bData; // °ª
	
		if(tens && value >= 9) {
			if(value == 9) {
				st.push(0);
			} else {
				st.push(value%10 + 1);	
			}			
			tens = true;
		} else if (tens && value < 9) {
			st.push(value%10 + 1);
			tens = false;
		} else if (!tens && value >=10 ) {
			st.push(value%10);
			tens = true;
		} else {
			st.push(value%10);
			tens = false;
		}
		
		aPointer--;
		bPointer--;
	}
	
	while(aPointer >= 0) {
		int aData = a[aPointer] - '0';
		
		if(tens) { 
			if(aData + 1 == 10) {
				st.push(0);
				tens = true;
			} else {
				st.push(aData + 1);
				tens = false;
			}
		} else {
			st.push(aData);
		}
		aPointer--;	
	}
	
	while(bPointer >= 0) {
		int bData = b[bPointer] - '0';
		
		if(tens) { 
			if(bData + 1 == 10) {
				st.push(0);
				tens = true;
			} else {
				st.push(bData + 1);
				tens = false;
			}
		} else {
			st.push(bData);
		}
		bPointer--;	
	}
	
		
	if(aPointer < 0 && bPointer < 0 && tens) {
		st.push(1);
	}
	
	while(!st.empty()) {
		cout << st.top();
		st.pop();
	}
	
	return 0;
	
}
