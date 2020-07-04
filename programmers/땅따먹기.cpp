/*
** programmers-¶¥µû¸Ô±â.cpp
** 2020-06-08
*/

#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

int cache[100001][4] = {0,};
int size;

int solution(vector<vector<int> > board)
{
    int answer = 0;
	size = board.size();
	
	for(int i=0; i<4; i++) {
		cache[0][i] = board[0][i];
	}
	
	for(int i=1; i<size; i++) {
		for(int j=0; j<4; j++) {
			for(int k=0; k<4; k++) {
				if(j != k) {
					cache[i][j] = max(cache[i][j], cache[i-1][k]+board[i][j]);					
				}
			}
		}
	}
	
	for(int i=0; i<4; i++) {
		answer = max(answer, cache[size-1][i]);
	}	
	
    return answer;
}

int main(void) {
	vector<vector<int> > v;
	
	vector<int> a;
	vector<int> b;
	vector<int> c;

	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	a.push_back(5);
	
	b.push_back(5);
	b.push_back(6);
	b.push_back(7);
	b.push_back(8);
	
	c.push_back(4);
	c.push_back(3);
	c.push_back(2);
	c.push_back(1);
	
	v.push_back(a);
	v.push_back(b);
	v.push_back(c);
	solution(v);
	
	return 0;
}
