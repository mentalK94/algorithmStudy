/*
** programmers-�Ա��ɻ�.cpp 
** 2020-05-09
*/

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

long long solution(int n, vector<int> times) {
    unsigned long long answer = 0;
    unsigned long long highTime;
    unsigned long long midTime;
    unsigned long long lowTime = 1;
    unsigned long long acceptableNumber=0;
    bool flag = false;
    
    sort(times.begin(), times.end());
    
	highTime = times[times.size()-1]*n;
	
	while(true) {
		
		midTime = (highTime+lowTime)/2;
		acceptableNumber = 0;
		
		for(int i=0; i<times.size(); i++) {
			acceptableNumber += (midTime/times[i]);
		}
		
		if(acceptableNumber > n) { // ���밡�� �� �ο��� �ʰ��� ��� -> �ð��� ������! 
			highTime = midTime-1;
		} else if(acceptableNumber == n) { // ���밡�� �� �ο��� ������� 			
			answer = midTime;
			highTime = midTime-1;	
		} else {
			lowTime = midTime+1;
		}
        if(lowTime > highTime) {
            return lowTime;
        }
	}

    return answer;
}

int main(void) {
	
	int n = 6;
	vector<int> times;
	times.push_back(7);
	times.push_back(10);
	
	cout << solution(n, times) << endl;
	
	return 0;
}

