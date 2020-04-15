/*
** programmers-카드게임.cpp
** 2020-04-15
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int point = 0;
int maxPoint = 0;
int leftMaxPoint = 0;
vector<int> leftTemp;
int tempPointer = 0;

bool compare(int a, int b) {
	return a>b;
}

void game(vector<int> left, vector<int> right, int point) {
	
	// 1. 남은 카드가 없는 경우
	if(!(left.size() > 0 && right.size() > 0)) {
		maxPoint = max(point, maxPoint);
		return;
	}
		
	// 2. 왼쪽이 오른쪽보다 큰 경우 
	if(left.front() <= right.front()) {
		
		// 2-1. 왼쪽 카드더미중 가장 큰 수보다 오른쪽 카드가 더 큰 경우 -> 이 때는 왼쪽 카드더미만 소진되므로
		// 양쪽 카드모두를 버려줘야 한다. 
		left.erase(left.begin());
		if(leftMaxPoint > right.front()) {									
			game(left, right, point);			
		} else {
			right.erase(right.begin());
		
			leftTemp.erase(leftTemp.begin(), leftTemp.end()); 
			for(int i=0; i<left.size(); i++) {
				leftTemp.push_back(left[i]);
			}  
			
			sort(leftTemp.begin(), leftTemp.end(), compare);
			leftMaxPoint = leftTemp[0];
			game(left, right, point);	
		}
		
	} else { // 3. 왼쪽이 오른쪽보다 작은 경우 -> 오른쪽 버리고 포인트 획득
		point += right.front();
		right.erase(right.begin());
		game(left, right, point);
	}
}

int solution(vector<int> left, vector<int> right) { 

	for(int i=0; i<left.size(); i++) {
		leftTemp.push_back(left[i]);
	}  
	
	sort(leftTemp.begin(), leftTemp.end(), compare);
	leftMaxPoint = leftTemp[0];
	
	game(left, right, point);
    
    return maxPoint;
}

int main(void) {
	
	vector<int> left;
	vector<int> right;
	
	left.push_back(1);
	left.push_back(1);
	left.push_back(1);
	left.push_back(1);
	left.push_back(3);
	right.push_back(2);
	right.push_back(3);
	right.push_back(1);
	right.push_back(1);
	right.push_back(1);
	
	cout << solution(left, right) << endl;
	
	return 0;
}
