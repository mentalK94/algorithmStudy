/*
** programmers-���� ���ڴ� �Ⱦ�.cpp
** 2020-02-27
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    answer.push_back(arr.front());
    for(int i=1; i<arr.size(); i++) {
    	if(answer.back() != arr[i]) {
    		answer.push_back(arr[i]);
		} else {
			continue;
		}
	}

    // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
    for(int i=0; i<answer.size(); i++) {
    	cout << answer[i] << " ";
	}

    return answer;
}

