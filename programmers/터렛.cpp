/*
** programmers-≈Õ∑ø.cpp
** 2020-03-11
*/

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {
	return a<b;
}

string solution(vector<string> participant, vector<string> completion) {
	
	string answer; 
	
	sort(participant.begin(), participant.end(), compare);
	sort(completion.begin(), completion.end(), compare);
	
	for(int i=0; i<participant.size(); i++) {
		if(participant[i] == completion[i]) {
			continue;
		} else {
			answer = participant[i];
			break;
		}
	}

    return answer;
}
