#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int length = 0;

bool solution(vector<int> arr)
{
    bool answer = true;
	length = arr.size();
	
	sort(arr.begin(), arr.end());
	
	for(int i=0; i<length; i++) {
		if(arr[i] != i+1) {return false;}
	} 
	
   
    return true;
}

int main(void) {
	
	vector<int> arr;
	arr.push_back(4);
	arr.push_back(1);
	arr.push_back(3);
	arr.push_back(2);
	
	cout << solution(arr) << endl;
	
	return 0;
}

