/*
** programmers-2019 kakao blind recruitment ½ÇÆĞÀ².cpp
** 2020-05-14
*/

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int apply[502] = {0,}; // 1 ~ 501
int fail[502] = {0,}; // 1 ~ 501
double fail_rate[502] = { 0, };

bool compare(int a, int b) {
	return a>b;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int apply_num = 0;
    int idx = 0;
    double temp_max_rate = 0;
    
    sort(stages.begin(), stages.end());
    
    for(int i=0; i<stages.size(); i++) {    	
    	fail[stages[i]] += 1;
	}
	
	apply[N+1] = fail[N+1];
	for(int i=N; i>0; i--) {    	
    	apply[i] = apply[i+1] + fail[i];
	}
    
   	for(int i=1; i<=N; i++) {
		fail_rate[i] = (double)fail[i] / (double)apply[i];
	}
	
	for(int i=1; i<=N+1; i++) {    	
    	cout << i << " : " << fail_rate[i] << endl;
	}
	
	for(int i=1; i<=N; ) {
		if(fail_rate[i] == -1) {
			i++;
			continue;
		}
		idx = i;
		temp_max_rate = fail_rate[i];
		for(int j=1; j<=N; j++) {
			if(temp_max_rate < fail_rate[j] && fail_rate[j] != -1) {
				idx = j;
				temp_max_rate = fail_rate[j];
			}
		}
		
		answer.push_back(idx);
		fail_rate[idx] = -1;
	}
	
	for(int i=0; i<answer.size(); i++) {
		cout << answer[i] << " ";
	}
	
    
    return answer;
}

int main(void) {
	vector<int> stages;
	stages.push_back(2);
	stages.push_back(1);
	stages.push_back(2);
	stages.push_back(6);
	stages.push_back(2);
	stages.push_back(4);
	stages.push_back(3);
	stages.push_back(3);
	solution(5, stages);
}

