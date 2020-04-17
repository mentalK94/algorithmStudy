/*
** programmers-ī��.cpp
** 2020-04-17
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int redX, redY;
    
    // 1. red�� ������ ã�ƶ� -> red������ (x, y)�� ��� ī�� ũ��� (x+2, y+2)�� �ȴ�
    // 2. �־��� brown������ ���� red������ ã�ƶ� -> red������ (x, y)�� ��� brown ������ 2x+2y+4�� �ȴ�
    // ����) 1 < x*y < 2,000,000
    
    for(int i = red; i>=(red/i); i--) {
    	if((red%i) != 0)  { // �簢���� �̷� �� ���� ��� ����     		
    		continue;
		}
		
		// 3. red������ �簢���̹Ƿ� x*y������ �� ����������.
		redX = i;
		redY = (int)(red/redX);
		if(2*redX + 2*redY + 4 == brown) { // �簢���� ����� ã����� 	
			// cout << redX << redY << endl;		
			answer.push_back(redX);
			answer.push_back(redY);
			break;
		}
		
	}
    return answer;
}

int main(void) {
	
	vector<int> v;
	
	v = solution(24, 24);
	cout << v[0] << ", " << v[1] << endl;
}
