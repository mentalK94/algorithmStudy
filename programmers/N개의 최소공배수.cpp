/*
** programmers-N개의 최소공배수.cpp
** 2020-05-18
*/

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;


int solution(vector<int> arr) {
    int answer = 0;
    int n, size = arr.size();
    bool isLCM;
    
    sort(arr.begin(), arr.end());
    n = arr[arr.size()-1];    
    
    for(int i=n; ; i+=n) {
    	isLCM = true;
    	for(int j=0; j<size-1; j++) {
    		if(i%arr[j]!=0) {
    			isLCM = false;
    			break;
			}
		}
		
		if(isLCM) {
			return i;
		}
	}
    
}

int main(void) {
	vector<int> arr;
	
	arr.push_back(2);
	arr.push_back(6);
	arr.push_back(8);
	arr.push_back(14);
	
	cout << solution(arr);
	return 0;
}
