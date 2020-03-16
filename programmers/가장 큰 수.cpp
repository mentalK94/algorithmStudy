/*
** programmers-가장 큰 수.cpp
** 2020-03-16
*/

#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(int numA, int numB) {
	int lengthA=0, lengthB=0, tempA, tempB;
	stack<int> a, b;
	int t, k;
	
	tempA = numA; tempB = numB;
		
	while(tempA > 0) {		
		tempA /= 10;
		lengthA++;		
	}
	
	while(tempB > 0) {
		tempB /= 10;
		lengthB++;
	}
	
	tempA = numA; tempB = numB;
	
	for(int i=lengthA; i>0; i--) {		
		a.push(tempA%10);
		tempA/=10;
	}
	
	for(int i=lengthB; i>0; i--) {		
		a.push(tempB%10);
		tempB/=10;
	}
	
	while(!a.empty() && !b.empty()) {
		t = a.top();
		k = b.top();
		
		if(t!=k) {
			if(t>k) {
				return true;
			} else {
				return false;
			}
		}
		
		a.pop(); b.pop();
	}
	
	while(!a.empty()) {
		t = a.top();
		if(t!=k) {
			if(t>k) {
				return true;
			} else {
				return false;
			}
		}
		a.pop();
	}
	
	while(!b.empty()) {
		k = b.top();
		if(t!=k) {
			if(t>k) {
				return true;
			} else {
				return false;
			}
		}
		b.pop();
	}
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<int> tempArr;
    
    sort(numbers.begin(), numbers.end(), compare);
    
    for(int i=0; i<numbers.size(); i++) {
    	cout << numbers.at(i) << endl;
	}
    
    return answer;
}
