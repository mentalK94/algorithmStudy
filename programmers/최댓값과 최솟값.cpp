/*
** programmers-ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª.cpp
** 2020-05-16
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> n;
    char com;
	string min, max;
	bool is_minus = false;
    int number;
    
   	for(int i=0; i<s.size(); i++) {
   		com = s[i];
				
		if(com == '-') {
			is_minus = true;
			continue
		} else if(com-'0'>=0 && com-'0'<=9) {
			number *= 10;
			number += s[i]-'0';			
		} else {
			if(is_minus == true) {
				number *= -1;
			}		
			is_minus = true;
			n.push_back(number);
			number = 0;
		}
		
	} 
	
	if(is_minus == true) {
		number *= -1;
	}
	is_minus = true;
	n.push_back(number);
	
	sort(n.begin(), n.end());
	
	min = to_string(n[0]);
	max = to_string(n[n.size()-1]);		
	
    answer += min;
    answer += " ";
    answer += max;
    
    return answer;
}
