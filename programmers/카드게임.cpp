/*
** programmers-ī�����.cpp
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
	
	// 1. ���� ī�尡 ���� ���
	if(!(left.size() > 0 && right.size() > 0)) {
		maxPoint = max(point, maxPoint);
		return;
	}
		
	// 2. ������ �����ʺ��� ū ��� 
	if(left.front() <= right.front()) {
		
		// 2-1. ���� ī������� ���� ū ������ ������ ī�尡 �� ū ��� -> �� ���� ���� ī����̸� �����ǹǷ�
		// ���� ī���θ� ������� �Ѵ�. 
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
		
	} else { // 3. ������ �����ʺ��� ���� ��� -> ������ ������ ����Ʈ ȹ��
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
