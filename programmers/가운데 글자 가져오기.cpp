/*
** programmers-가운데 글자 가져오기.cpp
** 2020-02-27
*/

#include <string>
#include <vector>

using namespace std;

string solution(string s) {
	
    string answer = "";
    int size = s.size();
    bool isEven;
    
    if(size%2 == 0) {
    	isEven = true;
    	answer = s[size/2];
	} else {
		isEven = false;
		answer = s[size/2-1] + s[size/2];
	}
	
    return answer;
}
