/*
** programmers-2020 kakao blind recruitment 괄호 변환.cpp
** 2020-06-07
*/

#include <string>
#include <vector>

using namespace std;

string solution(string p) {
    string answer = "";
    string u_string = ""; 
    string v_string = "";
    int u_left_cnt = 0; // u문자열의 왼쪽괄호 개수 
    int u_right_cnt = 0; // u문자열의 오른쪽괄호 개수
	int idx = 0;
	int clear_idx = 0; // 완료된 문자열 인덱스 
	bool is_right_string = false; // 올바른 문자열인지 확인 플래그 
    
    // 문자열을 u, v로 분리 
    while(idx < p.length()) {
    	
    	if(u_string == "") { // u_string이 빈 문자열인 경우 
    		// 첫 번째 문자가 '('인 경우
			if(p[idx] == '(') {
				is_right_string = true; 
				u_left_cnt += 1;
				
				while(u_left_cnt != u_right_cnt) {
					idx++;
					if(p[idx] == ')') {
						u_right_cnt += 1;
					} else {
						u_left_cnt += 1;
					}
				}
			}
			
			//  첫 번째 문자가 ')'인 경우
			if(p[i] == ')') {
				is_right_string = false; 
				u_right_cnt += 1;
				
				while(u_left_cnt != u_right_cnt) {
					idx++;
					if(p[idx] == ')') {
						u_right_cnt += 1;
					} else {
						u_left_cnt += 1;
					}
				}
			}
			
			u_string = p.substr(clear_idx, idx+1);
			v_string = p.substr(idx+1, p.length());
		} else { // u_string에 문자열이 존재하는 경우 
			
			if(is_right_string) { // u string이 올바른 문자열인 경우 
				if(v_string == "") {
					return u_string;
				} else {
					answer += u_string;
					u_left_cnt = 0;
					u_right_cnt = 0;
					is_right_string = false;
					idx++;
					continue;
				}
			} else { // u_string이 올바른 문자열이 아닌 경우 
				
			}
		}
    	
	}
    
    return answer;
}
