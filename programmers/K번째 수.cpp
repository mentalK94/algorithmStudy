/*
** programmers-완주하지못한선수.cpp.cpp
** 2020-02-27
*/

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	
	vector<int> answer;
	
	for(int i=0; i<3; i++) {
		vector<int> tempArray;
		int start = commands[i][0];
		int end = commands[i][1];
		int k = commands[i][2];
		
		for(int j=start-1; j<end; j++) {
			tempArray.push_back(array[j]);
		}
		
		sort(tempArray.begin(), tempArray.end());
	}
	
	
	
	
	
	
    vector<int> answer;
    return answer;
}
