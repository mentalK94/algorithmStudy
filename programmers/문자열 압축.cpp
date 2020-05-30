/*
** programmers-���ڿ� ����.cpp
** 2020-05-31
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = 100000;
    int cnt = 1;
    string temp, result;
    
    if(s.length() == 1) { return 1; }
    
    for(int i=1; i<=s.length() / 2; i++) { // i : ���ڿ��� �ڸ��� ����(����) 
    	
        result = ""; // ���� ��ó�� ���ڿ� 
        
        for(int j=0; j<s.length(); j+=i) {
        	
            temp = s.substr(j, i); // �񱳱��� ���ڿ� 
            
            if(j+i > s.length() || temp != s.substr(j+i, i)) { // ���ڿ��� ���� �ʰų� �� ���̸� �ʰ��� ��� 
                if(cnt != 1) {
                	result += to_string(cnt);
				}
                    
                result += temp;
                cnt = 1;
            }
            else {
            	cnt++;
			}
                
        }
        
        if(answer >= result.length()) {
            answer = result.length();
        }
        
    }

    
    return answer;
}
