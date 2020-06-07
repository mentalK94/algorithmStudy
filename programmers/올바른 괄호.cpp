/*
** programmers-올바른 괄호.cpp
** 2020-06-07
*/

#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{    
    int right_cnt = 0;
    int left_cnt = 0;

	if(s.length()%2 == 1) {
		return false;
	}
	
	for(int i=0; i<s.length(); i++) {
		if(left_cnt < right_cnt) {
			return false;
		}
		
		if(s[i] == '(') {
			left_cnt += 1;
		} else {
			right_cnt += 1;
		}
	}
	
	if(left_cnt == right_cnt) {
		return true;
	} else {
		return false;
	}
}
