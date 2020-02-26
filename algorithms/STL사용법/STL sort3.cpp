/*
** 학생을 나타낼 수 있는  정보가 이름, 성적, 생년월일일 때 학생을
** 성적 순서대로 나열하고자 한다.
** 다만 성적이 동일한 경우 나이가 더 어린 학생이 더 우선순위가 높다. 
*/

/* <학생명단>
** 학생 1 : 이영유/92점/1994-12-24 
** 학생 2 : 황지우/100점/1993-11-15
** 학생 3 : 김성령/88점/1995-02-06
** 학생 4 : 오인영/76점/1996-12-13
** 학생 5 : 권고은/95점/1996-12-14
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<string, pair<int, int> > a,
			pair<string, pair<int, int> > b) {
	if(a.second.first == b.second.first) {
		return a.second.second > b.second.second;
	} else {
		return a.second.first > b.second.first;
	}
	
}

int main(void) {
	vector<pair<string, pair<int, int> > > v;
	v.push_back(pair<string, pair<int, int> >("이영유", pair<int, int>(92, 19941214)));
	v.push_back(pair<string, pair<int, int> >("황지우", pair<int, int>(100, 19931115)));
	v.push_back(pair<string, pair<int, int> >("김성령", pair<int, int>(95, 19950206)));
	v.push_back(pair<string, pair<int, int> >("오인영", pair<int, int>(100, 19961213)));
	v.push_back(pair<string, pair<int, int> >("권고은", pair<int, int>(95, 19961214)));
	
	sort(v.begin(), v.end(), compare);
	for(int i=0; i<v.size(); i++)  {
		cout << v[i].first << ' ';
	}
	
	return 0;
}
