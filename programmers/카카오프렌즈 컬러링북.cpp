/*
** programmers-카카오프렌즈 컬러링북.cpp
** 2020-05-19
*/

#include <vector>

using namespace std;

vector<vector<int>> s_picture;
int is_visited[101][101];
int area_cnt; // 영역의 개수 
int max_size_area; // 최대영역 사이즈 
int dx[4] = {0, 1, -1, 0};
int dy[4] = {1, 0, 0, -1};
int M, N, temp_cnt;


void dfs(int x, int y, int pic_n)  {
	
	if((s_picture[x][y] != pic_n) || (is_visited[x][y] == 1)) {
		return;
	}
	
	is_visited[x][y] = 1;
	temp_cnt++;
	max_size_area = max(max_size_area, temp_cnt);
	
	for(int i=0; i<4; i++)  {
		
		int rx = x+dx[i];
		int ry = y+dy[i];
		
		if(rx<M && rx>=0 && ry<N && ry>=0) {
			if(s_picture[rx][ry] == pic_n) {
				dfs(rx, ry, pic_n);
			}
		}
		
	}
	
	
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {    
    
    s_picture = picture;
    int pic_n = 0;
    M = m; N = n;
    is_visited = {0,};
    area_cnt = 0; // 영역의 개수 
	max_size_area = 0; // 최대영역 사이즈 
    
    for(int i=0; i<m; i++) {
		for(int j=0; j<n; j++) {
			is_visited[i][j] = 0;
		}
	}
    
	for(int i=0; i<m; i++) {
		for(int j=0; j<n; j++) {
			if(s_picture[i][j] == 0 || is_visited[i][j] == 1) { // 여백인 경우거나 이미 방문한 경우 -> pass 
				continue;			 
			} else {
				temp_cnt = 0;
				area_cnt++;
				dfs(i, j, s_picture[i][j]);
			}						
		}
	}
    
    vector<int> answer(2);
    answer[0] = area_cnt;
    answer[1] = max_size_area;
    return answer;
}
