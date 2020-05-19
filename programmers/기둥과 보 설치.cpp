/*
** programmers-2020 카카오 블라인드 채용_기둥과 보 설치.cpp
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
    	
		x = build_frame[i][0]; // x좌표 
		y = build_frame[i][1]; // y좌표 
		a = build_frame[i][2]; // 0:기둥, 1:보 
		b = build_frame[i][3]; // 0:삭제, 1:설치 
		
		// 1. 기둥을 설치하는 경우 -> 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나 다른 기둥위에 있어야함. 
		if(a == 0 && b == 1) {
			
			// 1. 바닥에 있는 경우 
			if(y == 0) {
				column[x][y] = 1;
				continue;
			}
			
			// 2. 보의 한쪽 긑 부분 위에 있는 경우
			
			// 설치할 기둥이 양쪽 끝 중에 하나인 경우			
			if(x == 0 || x == n) {
				if(bo[0][y] == 1) { // 2-1. 설치할 기둥이 맨 왼쪽인 경우 
					column[x][y] = 1;
					continue;
				} else if(bo[n-1][y] == 1) { //  2-2. 설치할 기둥이 맨 오른쪽인 경우 
					column[x][y] = 1;
					continue;
				}				 
			} else {  
				if((bo[x][y] == 1 && bo[x-1][y] == 0) || (bo[x][y] == 0 && bo[x-1][y] == 1)) { // 2-3. 기둥이 보 왼쪽 끝인 경우 
					column[x][y] = 1;
					continue;
				}
			}		
			
			// 3. 다른 기둥 위에 있는 경우
			if(column[x][y-1] == 1) {
				column[x][y] = 1;
			}
			continue;
		}
		
		// 2. 보를 설치하는 경우
		if(a == 1 && b == 1) {
			// 1. 한쪽 끝 부분이 기둥 위에 있는 경우
			if(column[x][y] == 1 || column[x+1][y] == 1) {
				bo[x][y] = 1;
			}
			
			// 2. 양쪽 끝 부분이 다른 보와 동시에 연결되어 있는 경우
			if(bo[x-1][y] == 1 && bo[x+1][y] == 1)  {
				bo[x][y] = 1;
			}
			continue;
		}
		
		// 3. 기둥을 삭제하는 경우
		if(a == 0 && b == 0) {
			// 삭제 가능여부 확인
			if()  {
				
			}
		}
		
		// 4. 보를 삭제하는 경우 
		if(a == 1 && b == 0) {
			
		}
			
	}
    
    return answer;
}
