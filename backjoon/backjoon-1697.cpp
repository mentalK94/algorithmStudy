/*
** backjoon-1697.cpp
** ¼û¹Ù²ÀÁú 
** 2020-03-11
*/

#include <iostream>
#include <queue>

int checked[100001] = {0};
int dx[2] = {-1, 1};

using namespace std;

void bfs(int n, int k) {
	
	queue<int> q;
	q.push(n);
	checked[n] = 1;
	
	while(!q.empty()) {
		int x = q.front();
		if(x==k) {
			cout << checked[k]-1 << endl;
			break;
		} else if(x>k && checked[x-1] == 0) {
			q.push(x-1);
			checked[x-1] = checked[x]+1;
		} else {
			if(x*2<=100000 && checked[x*2] == 0) {
				q.push(2*x);
				checked[x*2] = checked[x]+1;
			}
			
			if(x+1<=100000 && checked[x+1] == 0) {
				q.push(x+1);
				checked[x+1] = checked[x]+1;
			}
			
			if(x-1>=0 && checked[x-1] == 0) {
				q.push(x-1);
				checked[x-1] = checked[x]+1;
			}
		}
		q.pop();
	}
}

int main(void) {

	int n, k;
	
	cin >> n >> k;
	
	bfs(n, k);

	return 0;
	
}
