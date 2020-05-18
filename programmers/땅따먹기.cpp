/*
** programmers-¶¥µû¸Ô±â.cpp
** 2020-05-18
*/

#include <algorithm>
#include <vector>
using namespace std;

vector<vector<int> > board_v;
int cache[100000][4] = {0,};
int size;

int dp(int order, int pre_idx, int idx) {
	
	if(order < 0) {
		return 0;
	}
	
	if(pre_idx = -1) {
		return board_v[order][idx];
	}
	
	if(cache[order][idx] != 0) {
		return cache[order][idx];
	}
	
	return cache[order][idx] = max(cache[order][idx], cache[order-1][pre_idx] + board_v[order][idx]);
	
	int temp = idx;
	
	for(int cnt=1; cnt<4; cnt++) {
		
		if(idx+1 == 4) {
			idx = -1;
		}
		
		dp(order-1, temp, idx+1);
		
		idx++;
	}
}

int solution(vector<vector<int>> board)
{
    int answer;
    board_v = board;
	size = board.size();
	
	dp(size-1, -1, 0);
	dp(size-1, -1, 1);
	dp(size-1, -1, 2);
	dp(size-1, -1, 3);
	
	sort(cache[size-1], cache[size-1]+4);
	answer = cache[size-1][3];

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
