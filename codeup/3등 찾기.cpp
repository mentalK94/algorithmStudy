// codeup - 데이터 정렬(small) 
// 2020-02-06

#include <iostream> 
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<string, int> a,
			pair<string, int> b) {
	
	return a.second > b.second;
}


int main(void) {
	
	int number;
	vector<pair<string, int> > v;
	
	cin >> number;
	
	for(int i=0; i<number; i++) {
		string name;
		int score;
		cin >> name;
		cin >> score;
		v.push_back(pair<string, int>(name, score));
	}
	
	sort(v.begin(), v.end(), compare);
	
	cout << v[2].first;
	
	return 0;
}
