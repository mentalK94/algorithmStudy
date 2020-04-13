/*
** ���.cpp
** 2020-04-13 
*/

#include <iostream>

using namespace std;

int maxPay = 0;
int time[16];
int pays[16];
int n; 

void consultingPay(int day, int pay) {		
	
	// 1. ���Ⱓ�� ��ȿ���� ���� Ȯ��
	if(day >= n+1) {
		maxPay = max(pay, maxPay);	
		return;
	}
				
	// 2. �ش糯�� ����� �ϴ� ���
	if(day + time[day] <= n+1)
		consultingPay(day+time[day], pay+pays[day]);	
		
    // 3. �ش糯�� ����� ���� �ʴ� ��� 
    if(day + 1 <= n+1 && time[day] != 1)
		consultingPay(day+1, pay);
}

int main(void) {
		
	cin >> n;
//	ios::sync_with_stdio(false);
//    cin.tie(NULL);
//    cout.tie(NULL);
	
	for(int i=1; i<=n; i++) {
		cin >> time[i] >> pays[i];		
	}
	
	consultingPay(1, 0);
	
	cout << maxPay << endl;
	return 0;
}


