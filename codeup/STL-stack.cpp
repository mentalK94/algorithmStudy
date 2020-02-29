/*
** STL stack.cpp
** 2020-02-27
*/

#include <iostream>
#include <stack>

using namespace std;

int main(void) {
	
	stack<string> commands;
	int number;
	
	cin >> number;
	
	for (int i=0; i<number; i++) {
		
		string command;
		cin << command;
		commands.push(command);
		
		
		
		
	}
	
	return 0;
	
}
