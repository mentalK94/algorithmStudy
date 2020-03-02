/*
** 회의실 배정 
** backjoon-1931.cpp
** 2020-03-02
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<long long int, pair<long long int, long long int> > a,
			pair<long long int, pair<long long int, long long int> > b) {

	if(a.first == b.first) {
		return a.second.first < b.second.first;
	} else {
		return a.first < b.first;
	}
}

int main(void) {
	
	int n, count=0;
	long long int start, end, distance;
	vector<pair<long long int, long long int> > r;
	vector<pair<long long int, pair<long long int, long long int> > > v;
	
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> start >> end;
		distance = end - start;
		v.push_back(pair<long long int, pair<long long int, long long int> >
		(distance, pair<long long int, long long int>(start, end)));
	}
	
	sort(v.begin(), v.end(), compare);
	
	for(int i=1; i<n; i++) {
		bool flag = true;
		for(int j=0; j<r.size(); j++) {
			for(int long long k=r[j].first; k<=r[j].second; k++) {
				
				if(v[i].second.first == k || v[i].second.second == k) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			r.push_back(pair<long long int, long long int>(v[i].second.first, v[i].second.second));
			sort(r.begin(), r.end());
			for(int i=1; i<r.size(); i++) {
				if(r[i].first == r[i-1].second) {
					long long int s = r[i-1].first;
					long long int e = r[i].second;
					r.erase(r.begin()+i-1, r.begin()+i);
					r.push_back(pair<long long int, long long int>(v[i].second.first, v[i].second.second));
				}										
			}
			count++;
		}
	}
	
	cout << count << endl;
	
	return 0;
}
