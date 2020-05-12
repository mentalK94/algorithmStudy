/*
** programmers-나누어 떨어지는 숫자 배열.cpp
** 2020-05-12
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
	for(int i=0; i<arr.size(); i++) {
		if(arr[i] % divisor == 0) {
			answer.push_back(arr[i]);
		}
	}
	
	if(answer.size() > 0) {
		sort(answer.begin(), answer.end());	
	} else {
		answer.push_back(-1);
	}
	
	
    
    return answer;
}
