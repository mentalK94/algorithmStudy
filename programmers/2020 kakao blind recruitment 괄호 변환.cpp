/*
** programmers-2020 kakao blind recruitment ��ȣ ��ȯ.cpp
** 2020-06-07
*/

#include <string>
#include <vector>

using namespace std;

string solution(string p) {
    string answer = "";
    string u_string = ""; 
    string v_string = "";
    int u_left_cnt = 0; // u���ڿ��� ���ʰ�ȣ ���� 
    int u_right_cnt = 0; // u���ڿ��� �����ʰ�ȣ ����
	int idx = 0;
	int clear_idx = 0; // �Ϸ�� ���ڿ� �ε��� 
	bool is_right_string = false; // �ùٸ� ���ڿ����� Ȯ�� �÷��� 
    
    // ���ڿ��� u, v�� �и� 
    while(idx < p.length()) {
    	
    	if(u_string == "") { // u_string�� �� ���ڿ��� ��� 
    		// ù ��° ���ڰ� '('�� ���
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
			
			//  ù ��° ���ڰ� ')'�� ���
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
		} else { // u_string�� ���ڿ��� �����ϴ� ��� 
			
			if(is_right_string) { // u string�� �ùٸ� ���ڿ��� ��� 
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
			} else { // u_string�� �ùٸ� ���ڿ��� �ƴ� ��� 
				
			}
		}
    	
	}
    
    return answer;
}
