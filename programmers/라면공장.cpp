/*
** programmers-������.cpp
** 2020-05-06
*/

#include <string>
#include <queue>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
	return a>b;
}

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;    
    priority_queue<int, vector<int>, less<int> > max_pq;
    int day = 0;
    int idx = 0;
    
    while(day<k) {
    	
    	stock--;
    	day++;
    	
    	if(stock >= k-day) {
    		break;
		}
    	
    	// 1. �ش� ��¥�� ���޵Ǵ� �а��簡 �ִ� ��� �켱���� ť�� ���� 
		if(dates[idx] == day) {
			cout << "1";
			max_pq.push(supplies[idx]);
			idx++;
		}
		
		// 2. �а��簡 ��� ������ ��� ���ݱ��� �޾Ƴ��� �а��� �߿��� ���� ���� �� ���
		if(stock == 0) {
			cout << max_pq.size();
			stock += max_pq.top();
			max_pq.pop();
			answer++;
		} 
				
	}

    return answer;
}

int main(void) {
	
	vector<int> dates;
	vector<int> supplies;
	
	dates.push_back(4);
	dates.push_back(10);
	dates.push_back(15);
	
	supplies.push_back(20);
	supplies.push_back(5);
	supplies.push_back(10);
	
	cout << solution(4, dates, supplies, 30) << endl;
	return 0; 
}
