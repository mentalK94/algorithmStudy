/*
** programmers-��ųƮ��.cpp
** 2020-05-11
*/

#include <string>
#include <cstring>
#include <vector>
#include <iostream>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    int prior_arr[26];
    int prior_cnt = 0; // ��� ���ེų ����
	bool isAnswer = false; 
    
    memset(prior_arr, -1, sizeof(prior_arr)); // -1�� �ʱ�ȭ 
    
    for(int i=0; i<skill.length(); i++) {
    	prior_arr[skill[i]-65] = i; // A�� ��� 0�� �ε����� ���� 
	}
	
	for(int i=0; i<prior_arr.size(); i++) {
    	cout << prior_arr[i] << " ";
	}
	cout << endl;
    
    for(int i=0; i<skill_trees.size(); i++) {
    	string skill_str = skill_trees[i];
    	prior_cnt = 0;
    	isAnswer = true;
    	
    	for(int j=0; j<skill_str.length(); j++) {
    		if(prior_arr[skill_str[j]-65] == -1) { // ���ེų�� ���� ���� ��� 
    			continue;
			}
			
			if(prior_arr[skill_str[j]-65] != prior_cnt)	{ // ���ེų�� ����� �ʰ� ���� �ϴ� ��� 
				isAnswer = false;
				break; 
			}
			
			// ���ེų�� ���
			prior_cnt++; 
		}
		
		if(isAnswer) { answer++; }
	
	}
    
    return answer;
}
