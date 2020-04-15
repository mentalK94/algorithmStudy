/*
** programmers-도둑질.cpp
** 2020-04-15
*/

#include <iostream>
#include <vector>

using namespace std;

int maxMoney = 0;
int curMoney = 0;
int moneyCache[1000000] = { 0, };

void steal(vector<int> money, int curMoney, int cur, bool flag) {
	
	if(cur >= money.size()) {
		maxMoney = max(curMoney, maxMoney);	
		return;
	}
	
	// 현재 집을 지나칠 경우 -> 2번 이상 지나칠 수 없다
	if(flag) 
		steal(money, curMoney, cur+1, false); 
		
	// 현재 집을 도둑질 할 경우
	if(moneyCache[cur] != 0) {
		if(curMoney + money[cur] > moneyCache[cur]) {
			moneyCache[cur] = curMoney + money[cur];
		}		
	}
	else {
		moneyCache[cur] = curMoney + money[cur];			
	}
	
	steal(money, moneyCache[cur], cur+2, true);
}

int solution(vector<int> money) {
    
    steal(money, curMoney, 0, true);
    
    return maxMoney;
}


int main(void) {
	
	vector<int> money;
	money.push_back(1);
	money.push_back(2);
	money.push_back(3);
	money.push_back(1);
	
	cout << solution(money) << endl;
	
	return 0;
}
