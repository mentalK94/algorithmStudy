#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	vector<pair<int, string> > v;
	v.push_back(pair<int, string>(90, "������"));
	v.push_back(pair<int, string>(84, "������"));
	v.push_back(pair<int, string>(92, "������"));
	v.push_back(pair<int, string>(100, "�ڰǿ�"));
	v.push_back(pair<int, string>(68, "������"));
	
	sort(v.begin(), v.end());
	for(int i=0; i<v.size(); i++)  {
		cout << v[i].second << ' ';
	}
	
	return 0;
}
