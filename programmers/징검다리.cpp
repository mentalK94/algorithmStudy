/*
** programmers-Â¡°Ë´Ù¸®.cpp
** 2020-04-22
*/

#include <string>
#include <vector>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    vector<int> dist;

	rocks.push_back(0);
	rocks.push_back(n);
	
	sort(rocks.begin(), rocks.end());
    
    for(int i=0; i<rocks.size(); i++) {
    	
    	
    	
    	
    	
	}
    
    return answer;
}

int main(void) {
	
	vector<int> rocks;
	rocks.push_back(2);
	rocks.push_back(14);
	rocks.push_back(11);
	rocks.push_back(21);
	rocks.push_back(17);
	
	cout << solution(25, rocks, 2);	
	
	return 0;
}

