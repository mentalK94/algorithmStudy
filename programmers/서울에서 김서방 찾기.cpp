/*
** programmers-���￡�� �輭�� ã��.cpp
** 2020-05-12
*/

#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    
    for(int i=0; i<seoul.size(); i++) {
        if(seoul[i] == "Kim") {
        	return "�輭���� " + to_string(i) +"�� �ִ�" ;
		}
    }
    
}
