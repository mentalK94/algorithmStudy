/*
** programmers-2018 kakao blind recruitment 1차_비밀지도.cpp
** 2020-05-14
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int binary_arr1[16][16] = {0,};
int binary_arr2[16][16] = {0,};

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    //string str[];
    int num1, num2;    
    int idx1, idx2;    
    
	for(int i=0; i<n; i++) {
		num1 = arr1[i];
		num2 = arr2[i];
		
		idx1 = n-1;
		idx2 = n-1;
		while(num1 > 0) {			
			binary_arr1[i][idx1] = num1%2;
			num1 /= 2;
			idx1--;
		}
		while(num2 > 0) {			
			binary_arr2[i][idx2] = num2%2;
			num2 /= 2;
			idx2--;
		}
	}
	
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {			
			cout << binary_arr2[i][j];
		}	
		cout << endl;
	}
	
	for(int i=0; i<n; i++) {
		string str;
		for(int j=0; j<n; j++) {			
			if(binary_arr1[i][j] == 1 || binary_arr2[i][j] == 1) {
				str += "#";
			} else {
				str += " ";
			}
		}	
		answer.push_back(str);
	}
    
    return answer;
}

int main(void) {
	vector<int> a;
	vector<int> b;
	a.push_back(9);
	a.push_back(20);
	a.push_back(28);
	a.push_back(18);
	a.push_back(11);
	
	b.push_back(30);
	b.push_back(1);
	b.push_back(21);
	b.push_back(17);
	b.push_back(28);
	
	solution(5, a, b);
	return 0;
}
