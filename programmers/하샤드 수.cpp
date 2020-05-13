/*
** programmers-ÇÏ»þµå ¼ö.cpp
** 2020-05-13 
*/

#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int n = 0;
    int temp = x;
    
    while(temp>0) {
    	n += (temp%10);
    	temp /= 10;
	} 
	
	if(x % n != 0) {
		return false;
	}
    
    return answer;
}

