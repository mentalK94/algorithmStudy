/*
** programmers-다음 큰 숫자.cpp
** 2020-06-07
*/

#include <string>
#include <vector>

using namespace std;

int binaryCntFunc(int n) {
	int cnt = 0;
	
	while(n > 0) {
		if(n%2 == 1) {
			cnt++;
		}
		
		n /= 2;
	}
	
	return cnt;
}

int solution(int n) {
    int binaryCnt = 0;
	    
	binaryCnt = binaryCntFunc(n);
	
    for(int i=n+1; ; i++) {
    	if(binaryCntFunc(i) == binaryCnt) {
    		return i;
		}	
	}

}
