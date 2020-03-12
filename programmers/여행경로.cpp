/*
** programmers-여행경로.cpp
** 2020-03-12
*/

#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<vector<string> > tickets) {
    vector<string> answer;
    vector<pair<string, string> > map;
    
    for(int i=0; i<tickets.size(); i++) {    	
    	map.push_back(pair<string, string>(tickets[i][0], tickets[i][1]));		
	}
    
    
    
    
    return answer;
}

int main(void) {
	
	vector<vector<string> > tickets = {{"ICN", "JFK"}, {"HND", "IAD"}};
	return 0;
}
