/*
** programmers-완주하지못한선수.cpp
** 2020-02-27
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
			cout << participant[i] << endl;
			continue;
		} else {
			cout << participant[i] << endl;
			answer = participant[i];
			break;
		}
	}

    return answer;
}

int main(void) {
	
	vector<string> participant;
	vector<string> completion;
	
	participant.push_back("mislav");
	participant.push_back("stanko");
	participant.push_back("mislav");
	participant.push_back("ana");
	
	completion.push_back("stanko");
	completion.push_back("ana");
	completion.push_back("mislav");
	
//	for (int i=0; i<participant.size(); i++) {
//		cout << participant[i];
//	}
	string aaa = solution(participant, completion);
	cout << aaa;
	
	return 0;
} 
