/*
** programmers-최대공약수와 최소공배수.cpp
** 2020-05-13 
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;

int getGCM(int a, int b) {   
	
	if( a == b ){return a;}
	int min = a<b ? a:b;
	int max = a>b ? a:b;
	
	for(int i=min; i>0; i--) {
		if(max%i == 0 && min%i==0) {
			return i;
		}
	}
	return 1;
} 

int getLCM(int a, int b) {   
	
	if( a == b ){return a;}
	int min = a<b ? a:b;
	int max = a>b ? a:b;
	
	for(int i=max; ;i+=max) {
		if(i%min == 0){
			return i;
		}
	}
} 


vector<int> solution(int n, int m) {
    vector<int> answer;
    
    int gcm = getGCM(n, m);
    int lcm = getLCM(n, m);
    
    answer.push_back(gcm);
    answer.push_back(lcm);
    
    cout << gcm << endl;
    cout << lcm << endl;
    return answer;
}

int main(void) {
	solution(12, 42);
	
}


