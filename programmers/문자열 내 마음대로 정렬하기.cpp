/*
** programmers-문자열 내 마음대로 정렬하기.cpp
** 2020-05-12
*/

#include <string>
#include <vector>
#define A 97
#define Z 122

using namespace std;

bool compare(string str_a, string str_b) {
	return str_a < str_b;
}

vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    vector<string> temp;
        
    for(int i=A; i<=Z; i++) {
    	for(int j=0; j<strings.size(); j++) {
    		
    		if(strings[j][n] == i) {
    			temp.push_back(strings[j]);
			}
    		
		}
		
		if(temp.size() == 0) {
			continue;
		} else if(temp.size() == 1) {
			answer.push_back(temp[0]);
		} else {
			sort(temp.begin(), temp.end(), compare);
			for(int k=0; k<temp.size(); k++) {
				answer.push_back(temp[k]);
			}
		}
		
		temp.clear();
	}
    
    return answer;
}
