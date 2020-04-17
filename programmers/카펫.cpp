/*
** programmers-카펫.cpp
** 2020-04-17
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int redX, redY;
    
    // 1. red의 모형을 찾아라 -> red모형이 (x, y)인 경우 카펫 크기는 (x+2, y+2)가 된다
    // 2. 주어진 brown개수를 통해 red모형을 찾아라 -> red모형이 (x, y)인 경우 brown 개수는 2x+2y+4가 된다
    // 조건) 1 < x*y < 2,000,000
    
    for(int i = red; i>=(red/i); i--) {
    	if((red%i) != 0)  { // 사각형을 이룰 수 없는 경우 제외     		
    		continue;
		}
		
		// 3. red모형은 사각형이므로 x*y형으로 딱 떨어져야함.
		redX = i;
		redY = (int)(red/redX);
		if(2*redX + 2*redY + 4 == brown) { // 사각형의 모양을 찾은경우 	
			// cout << redX << redY << endl;		
			answer.push_back(redX);
			answer.push_back(redY);
			break;
		}
		
	}
    return answer;
}

int main(void) {
	
	vector<int> v;
	
	v = solution(24, 24);
	cout << v[0] << ", " << v[1] << endl;
}
