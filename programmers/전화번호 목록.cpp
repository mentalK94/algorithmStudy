/*
** 전화번호 목록.cpp
** 2020-03-06
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

bool compare(string s1, string s2) {
	return s1.size() < s2.size();
}

bool solution(vector<string> phone_book) {
    bool answer = true;
    int length;
    
    sort(phone_book.begin(), phone_book.end(), compare);
    
    for(int i=0; i<phone_book.size(); i++) {
    	cout << phone_book[i] << endl;
	}
    
    while(true) {
    	
	}
    
    return answer;
}

int main(void) {
	
	vector<string> phone_book;
	
	phone_book.push_back("97674223");
	phone_book.push_back("119");	
	phone_book.push_back("1195524421");
	
	solution(phone_book);
	return 0;
}


