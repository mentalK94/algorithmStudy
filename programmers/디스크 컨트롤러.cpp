/*
** programmers-��ũ ��Ʈ�ѷ�.cpp
** 2020-05-03
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool visited[500] = {false, };

bool compare(vector<int> a, vector<int> b) {	
	if(a.front() == b.front()) {
		return a.back() < b.back();
	} else {
		return a.front() < b.front();	
	}
}

int solution(vector<vector<int> > jobs) {
    int answer = 0;
    int size = jobs.size(); // ��ũ ���� 
    int spendTime = 0; // �� �ҿ�ð� 
    int time = 0; // ���� �ð�
    int workingRequestTime; // �۾��� ��û�Ǵ� ����
    int workingSpendTime; // �۾��� �ҿ�ð�
    bool flag = false;
    int idx;
    
    sort(jobs.begin(), jobs.end(), compare);
    
    for(int i=0; i<size; ) {
    	
    	if(visited[i]) { // �̹� �۾��� ��� 
    		i++;
    		continue;	
		}
    	    	
    	flag = false;
    	int temp = jobs[i][1];
    	for(int j=i; j<size; j++) {
    		if(time >= jobs[j][0] && !visited[j] && temp >= jobs[j][1]) { // ���� �ð��ȿ� ��û�ð��� �ְ� �۾��� ������� �ʾ����� �۾��ð��� �� ª�����
    			temp = jobs[j][1];
    			workingRequestTime = jobs[j][0];
    			workingSpendTime = jobs[j][1];
    			flag = true;
    			idx = j;
			}
		}
		
		if(flag) {
			visited[idx] = true;
		}
		
		if(!flag) {
			workingRequestTime = jobs[i][0];
    		workingSpendTime = jobs[i][1];
    		time = workingRequestTime;
    		visited[i] = true;
    		i++;
		}
	    	        
    	time += workingSpendTime;
        
    	spendTime += (time-workingRequestTime);
	}
	
	
	answer = spendTime/size;
    return answer;
}

int main(void) {
	
	vector<vector<int> > jobs;
	
	vector<int> a;
	vector<int> b;
	vector<int> c;
	
	a.push_back(0);
	a.push_back(3);
	
	b.push_back(1);
	b.push_back(9);
	
	c.push_back(2);
	c.push_back(6);

	jobs.push_back(a);
	jobs.push_back(b);
	jobs.push_back(c);

	solution(jobs);

	return 0; 
}
