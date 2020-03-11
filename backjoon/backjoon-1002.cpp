/*
** backjoon-1002.cpp
** �ͷ� 
** 2020-03-11
*/

#include <iostream>
#include <cmath>

using namespace std;

int main(void) {

 	int n, x[3], y[3], r1, r2;
	double distance; 
	 
	cin >> n;
	
	for(int i=0; i<n; i++) {
		
		for(int j=0; j<3; j++) {
			cin >> x[j];
		}
		
		for(int k=0; k<3; k++) {
			cin >> y[k];
		}
		
		distance = sqrt((x[0]-y[0])*(x[0]-y[0])+(x[1]-y[1])*(x[1]-y[1]));
		
		if(x[2]>y[2]) {
			r1 = x[2];
			r2 = y[2];
		} else {
			r2 = x[2];
			r1 = y[2];
		}
		
		if(distance==0 && r1==r2) { // �� ���� ��ġ�ϴ� ��� 
			cout << -1 << endl;			
			continue;
		}
		
		if((distance == r1+r2) || ((distance == r1-r2) && (distance != 0))) { // �� ���� �������� �����ϴ� ��� -> ����, ���� 
			cout << 1 << endl;
			continue;
		}
		
		if((distance > r1+r2) || (distance < r1-r2)) { // ������ �ʴ°�� -> �ָ� ������ �ְų�, �����ϰ� �ְų�(����x) 
			cout << 0 << endl;
			continue;
		}
		
		if((distance < r1+r2) && (distance > r1-r2)) { // �� ���� �� ������ ������ ��� 
			cout << 2 << endl;
			continue;
		}
 	}

	return 0;
	
}
