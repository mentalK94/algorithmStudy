/*
** programmers-Á¤¼ö »ï°¢Çü.cpp
** 2020-04-21
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int memory[501] = { 0, };
int tri[125251] = { 0, };
int triangleCache[125251] = { 0, };
int size = 0;

int getNumber(int idx, int height) {
	
	cout << "idx : " << idx << endl;
	
	if(idx > size) { 
		return 0;
	}
	//cout << height << " : " << memory[height] << endl;
	if(memory[height] != 0) {return memory[height];}
	
	return memory[height] = max(getNumber(2*idx, height+1)+tri[idx], getNumber(2*idx+1, height+1)+tri[idx]);
	
}

int solution(vector<vector<int> > triangle) {
    int answer = 0;
    int idx = 0;
    
    for(int i=0; i<triangle.size(); i++) {
    	for(int j=0; j<triangle[i].size(); j++) {
    		tri[idx++] = triangle[i][j];
    		size++;
		}
	}
	
	answer = getNumber(1, 1) + ;
    
    cout << answer << endl;
    return answer;
}


int main(void) {
	
	vector<vector<int> > triangle;
	vector<int> a;
	vector<int> b;
	vector<int> c;
	vector<int> d;
	vector<int> e;
	
	a.push_back(7);
	b.push_back(3);
	b.push_back(8);
	c.push_back(8);
	c.push_back(1);
	c.push_back(0);
	d.push_back(2);
	d.push_back(7);
	d.push_back(4);
	d.push_back(4);
	e.push_back(4);
	e.push_back(5);
	e.push_back(2);
	e.push_back(6);
	e.push_back(5);
	
	triangle.push_back(a);
	triangle.push_back(b);
	triangle.push_back(c);
	triangle.push_back(d);
	triangle.push_back(e);
		
	solution(triangle);
	
	return 0;
}
