/*
** programmers-짝지어 제거하기.cpp
** 2020-05-19
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

int solution(string s)
{
	vector<char> v;
    int answer = 0;
    int idx = -1;

    for(int i=0; i<s.length(); i++) {
    	v.push_back(s[i]);
        idx++;
    	        
    	if(v.size() >= 2) {
    		if(v[idx] == v[idx-1]) {
    			v.erase(v.begin()+(idx-1), v.begin()+(idx+1));    
                idx -= 2;
			}
		}
	}
	
	if(v.size() == 0) {
		return 1;
	} 

    return answer;
}
