/*
** programmers-문자열 다루기 기본.cpp
** 2020-05-12
*/

#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    if(!(s.size() == 4 || s.size() == 6)) {
    	return false;
	}
    
   	for(int i=0; i<s.size(); i++)  {
   		if(!(s[i]-'0'>=0 && s[i]-'0'<=9)) {
   			return false;
		}
	}
    
    return answer;
}
