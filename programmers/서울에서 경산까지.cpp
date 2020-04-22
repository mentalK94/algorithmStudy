/*
** programmers-서울에서 경산까지.cpp
** 2020-04-22
*/

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int memory[100001] = { 0, };
int size;

int dp(int idx, int K, vector<vector<int> > travel) {
	
	if(idx >= size || K < 0) {
		return 0;
	}
	
	if(memory[K] != 0) {
		return memory[K];
	}
	
	if(K >= travel[idx][0]) { // 도보 경로
		cout << "도보" << idx << endl;
//		cout << memory[K] << endl;
//		cout << K-travel[idx][0] << endl;
//		cout << endl;
		
		memory[K] = max(memory[K], dp(idx+1, K-travel[idx][0], travel) + travel[idx][1]);
		cout << memory[K] << endl;
	}
	
	if(K >= travel[idx][2]) { // 자전거 경로 
		cout << "자전거" << idx << endl;
//		cout << memory[K] << endl;
//		cout << K-travel[idx][2] << endl;
//		cout << endl;
		
		memory[K] = max(memory[K], dp(idx+1, K-travel[idx][2], travel) + travel[idx][3]);
		cout << memory[K] << endl;
	}
	
	return memory[K];
} 

bool compare(int a, int b) {
	return a>b;
}

int solution(int K, vector<vector<int> > travel) {
    int answer = 0;
    size = travel.size(); // travel 행의 갯수 : 거쳐가는 도시의 개수
    
    answer = dp(0, K, travel);
    
   	sort(memory, memory+100001, compare);
   	
//   	for(int i=0; i<10; i++) {
//   		cout << memory[i] << endl;	
//	}
    
     cout << answer << endl;
    return answer;
}

int main(void) {

	vector<vector<int> > travel;
	vector<int> a;
	vector<int> b;
	vector<int> c;
	// vector<int> d;
	
	a.push_back(500);
	a.push_back(200);
	a.push_back(200);
	a.push_back(100);
	b.push_back(800);
	b.push_back(370);
	b.push_back(300);
	b.push_back(120);
	c.push_back(700);
	c.push_back(250);
	c.push_back(300);
	c.push_back(90);
	
//	a.push_back(1000);
//	a.push_back(2000);
//	a.push_back(300);
//	a.push_back(700);
//	b.push_back(1100);
//	b.push_back(1900);
//	b.push_back(400);
//	b.push_back(900);
//	c.push_back(900);
//	c.push_back(1800);
//	c.push_back(400);
//	c.push_back(700);
//	
//	d.push_back(1200);
//	d.push_back(2300);
//	d.push_back(500);
//	d.push_back(1200);
	
	travel.push_back(a);
	travel.push_back(b);
	travel.push_back(c);
	// travel.push_back(d);

	solution(1650, travel);
	
	return 0;
}


