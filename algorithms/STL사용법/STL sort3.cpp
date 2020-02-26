/*
** �л��� ��Ÿ�� �� �ִ�  ������ �̸�, ����, ��������� �� �л���
** ���� ������� �����ϰ��� �Ѵ�.
** �ٸ� ������ ������ ��� ���̰� �� � �л��� �� �켱������ ����. 
*/

/* <�л����>
** �л� 1 : �̿���/92��/1994-12-24 
** �л� 2 : Ȳ����/100��/1993-11-15
** �л� 3 : �輺��/88��/1995-02-06
** �л� 4 : ���ο�/76��/1996-12-13
** �л� 5 : �ǰ���/95��/1996-12-14
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
	v.push_back(pair<string, pair<int, int> >("�̿���", pair<int, int>(92, 19941214)));
	v.push_back(pair<string, pair<int, int> >("Ȳ����", pair<int, int>(100, 19931115)));
	v.push_back(pair<string, pair<int, int> >("�輺��", pair<int, int>(95, 19950206)));
	v.push_back(pair<string, pair<int, int> >("���ο�", pair<int, int>(100, 19961213)));
	v.push_back(pair<string, pair<int, int> >("�ǰ���", pair<int, int>(95, 19961214)));
	
	sort(v.begin(), v.end(), compare);
	for(int i=0; i<v.size(); i++)  {
		cout << v[i].first << ' ';
	}
	
	return 0;
}
