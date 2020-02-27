#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
	
    int answer = n;
    
    for(int i=0; i<lost.size(); i++) {
    	int lostNumber = lost[i];

    	for(int j=0; j<reserve.size(); j++){
    		if(lostNumber == reserve[j]) { // 여분 가져온 학생이 잃어버린 경우 
				reserve.erase(reserve.begin()+j);
				lost.erase(lost.begin()+i);
				break;
			}
		}				
	}
    
    for(int i=0; i<lost.size(); i++) {
    	int lostNumber = lost[i];

    	for(int j=0; j<reserve.size(); j++){
    		if((lostNumber == reserve[j]-1) || (lostNumber == reserve[j]-1)) {
    			lost.erase(lost.begin()+i);
    			reserve.erase(reserve.begin()+j);
    			break;
			}
		}				
	}
    
    answer -= lost.size();
    
    return answer;
}
