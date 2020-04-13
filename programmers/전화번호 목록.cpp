/*
** 전화번호 목록.cpp
** 2020-03-06 -> 2020-04-13
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    int length;
    
    sort(phone_book.begin(), phone_book.end());
    
    for(int i=0; i<phone_book.size()-1; i++) {
    	if(phone_book[i].size() <= phone_book[i+1].size()) {
    		if(phone_book[i] == phone_book[i+1].substr(0, phone_book[i].size())) {
    			return false;
			} 
		}
		
		else {		
    		if(phone_book[i+1] == phone_book[i].substr(0, phone_book[i+1].size())) {
    			return false;
			} 
		}
	}
    
    return true;
}

int main(void) {
	
	vector<string> phone_book;
	
	phone_book.push_back("97674223");
	phone_book.push_back("119");	
	phone_book.push_back("1195524421");
	
	solution(phone_book);
	return 0;
}


