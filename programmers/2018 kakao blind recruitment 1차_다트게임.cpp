/*
** programmers-2018 kakao blind recruitment 1��_��Ʈ����.cpp
** 2020-05-14
*/

#include <string>
#include <iostream>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int idx = 0;
	int point[3];
	int n; 
    
    for(int i=0; i<dartResult.length(); i++) {
    	if(dartResult[i]-'0' >= 0 && dartResult[i]-'0' <= 9) { // ������ ��� 
    		if(dartResult[i+1]-'0' == 0) { // ���ڰ� 10�� ��� 
    			i++;
				n = 10;
			} else { // ���ڰ� �� �ڸ����� ���
                n = dartResult[i]-'0';
			}
			continue;
		}
					

		if(dartResult[i] == 'S') { // single
			point[idx++] = n;
			continue;
		} else if(dartResult[i] == 'D') { // double
			point[idx++] = n*n;
			continue;
		} else if(dartResult[i] == 'T') { // triple
			point[idx++] = n*n*n;
			continue;
		}
		
		if(dartResult[i] == '*') { // ��Ÿ��
			if(idx > 1) {
				point[idx-2] = 2*point[idx-2];
			} 	
			point[idx-1] = 2*point[idx-1];
		} else if(dartResult[i] == '#') { // ������ 
			point[idx-1] = (-1)*point[idx-1];
		} 
	}
    
    for(int i=0; i<3; i++) {
    	cout << point[i] << endl;
    	answer += point[i];
	}
	cout << answer << endl;
    return answer;
}

int main(void) {
	
	solution("1S2D*3T");
	return 0;
}
