/*
** programmers-2020 īī�� ����ε� ä��_��հ� �� ��ġ.cpp
** 2020-05-19
*/

#include <string>
#include <vector>

using namespace std;

int column[101][101] = {0,};
int bo[101][101] = {0,};

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    int x, y, a, b;
    
    for(int i=0; i<build_frame.size(); i++) {
    	
		x = build_frame[i][0]; // x��ǥ 
		y = build_frame[i][1]; // y��ǥ 
		a = build_frame[i][2]; // 0:���, 1:�� 
		b = build_frame[i][3]; // 0:����, 1:��ġ 
		
		// 1. ����� ��ġ�ϴ� ��� -> �ٴ� ���� �ְų� ���� ���� �� �κ� ���� �ְų� �ٸ� ������� �־����. 
		if(a == 0 && b == 1) {
			
			// 1. �ٴڿ� �ִ� ��� 
			if(y == 0) {
				column[x][y] = 1;
				continue;
			}
			
			// 2. ���� ���� �P �κ� ���� �ִ� ���
			
			// ��ġ�� ����� ���� �� �߿� �ϳ��� ���			
			if(x == 0 || x == n) {
				if(bo[0][y] == 1) { // 2-1. ��ġ�� ����� �� ������ ��� 
					column[x][y] = 1;
					continue;
				} else if(bo[n-1][y] == 1) { //  2-2. ��ġ�� ����� �� �������� ��� 
					column[x][y] = 1;
					continue;
				}				 
			} else {  
				if((bo[x][y] == 1 && bo[x-1][y] == 0) || (bo[x][y] == 0 && bo[x-1][y] == 1)) { // 2-3. ����� �� ���� ���� ��� 
					column[x][y] = 1;
					continue;
				}
			}		
			
			// 3. �ٸ� ��� ���� �ִ� ���
			if(column[x][y-1] == 1) {
				column[x][y] = 1;
			}
			continue;
		}
		
		// 2. ���� ��ġ�ϴ� ���
		if(a == 1 && b == 1) {
			// 1. ���� �� �κ��� ��� ���� �ִ� ���
			if(column[x][y] == 1 || column[x+1][y] == 1) {
				bo[x][y] = 1;
			}
			
			// 2. ���� �� �κ��� �ٸ� ���� ���ÿ� ����Ǿ� �ִ� ���
			if(bo[x-1][y] == 1 && bo[x+1][y] == 1)  {
				bo[x][y] = 1;
			}
			continue;
		}
		
		// 3. ����� �����ϴ� ���
		if(a == 0 && b == 0) {
			// ���� ���ɿ��� Ȯ��
			if()  {
				
			}
		}
		
		// 4. ���� �����ϴ� ��� 
		if(a == 1 && b == 0) {
			
		}
			
	}
    
    return answer;
}
