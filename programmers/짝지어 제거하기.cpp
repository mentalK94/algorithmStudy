/*
** programmers-짝지어 제거하기.cpp
** 2020-05-19
*/

#include <iostream>
#include <string>
using namespace std;

int solution(string s)
{
	vector<char> v;
    int answer = 0;

    for(int i=0; i<s.length(); i++) {
    	v.push_back(s[i]);
    	
    	if(v.size() >= 2) {
    		if(v[i] == v[i-1]) {
    			v.pop();
    			v.pop();
			}
		}
	}

    return answer;
}
