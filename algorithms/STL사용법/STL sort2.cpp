#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	vector<pair<int, string> > v;
	v.push_back(pair<int, string>(90, "±èÀ±¼º"));
	v.push_back(pair<int, string>(84, "À±ÁöÈñ"));
	v.push_back(pair<int, string>(92, "±¸¸íÈÆ"));
	v.push_back(pair<int, string>(100, "¹Ú°Ç¿ë"));
	v.push_back(pair<int, string>(68, "À±ÀçÇÑ"));
	
	sort(v.begin(), v.end());
	for(int i=0; i<v.size(); i++)  {
		cout << v[i].second << ' ';
	}
	
	return 0;
}
