/*
** programmers-콜라츠 추측.cpp
** 2020-05-13 
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(long long num) {
    int answer = -1;
    int cnt = 0;
    
    while(true) {
        
        if(num == 1) {
            answer = cnt;
            break;
        }
        if(cnt > 500) {
            break;
        }
        
        if(num%2==0) {
            num /= 2;                        
        } else {
            num *= 3;
            num += 1;            
        }        
        cnt++;
    }

	cout << answer << endl;
    return answer;
}

int main(void) {
	solution(626331);
} 

