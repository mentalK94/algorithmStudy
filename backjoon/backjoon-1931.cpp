/*
** 회의실 배정 
** backjoon-1931.cpp
** 2020-03-02
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<int, int> v1, pair<int, int> v2) {
	if(v1.second == v2.second)
		return v1.first < v2.first;
	else
		return v1.second < v2.second;
}

int main(void) {
	
	int n, k=0, start, end, count=0;
	vector<pair<int, int> > v;
	
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> start >> end;
		
		v.push_back(pair<int, int>(start, end));
	}
	
	sort(v.begin(), v.end(), compare);
	
	for(int i=0; i<v.size(); i++) {
		if(k<=v[i].first) {
			k = v[i].second;
			count++;
		}
 	}
	
	cout << count << endl;
	
	return 0;
}
