/**
 * Backjoon - 14503. 로봇 청소기
 * RobotCleaner_14503.java
 * @date 2020-10-17
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {

	static int N, M, answer;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int robotDir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(robotX, robotY, robotDir);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int dir) {
		
		// 1. 현재위치를 청소
		map[x][y] = 2; // 청소 표기
		answer++;
		 

		while(true) {
			// 2. 현재 위치에서 현재 방향 기준 왼쪽방향부터 차례대로 탐색
			// a. 왼쪽방향에 아직 청소하지 않은 공간이 존재한다면, 그방향으로 회전한 다음 한 칸 전진하고 1번부터 진행
			for(int i=0; i<4; i++) {
				dir = (dir+3)%4;
				if(map[x+dx[dir]][y+dy[dir]] == 0) {
					dfs(x+dx[dir], y+dy[dir], dir);
					return;
				}
			}
			
			// d. 네 방향 모두 청소가 이미 되었거나 벽인 경우, 뒤쪽방향이 벽이라 후진도 할 수 없는 경우
			int back = (dir+2)%4;
			if(map[x+dx[back]][y+dy[back]] == 1) {
				return;
			}
						
			// c. 네 방향 모두 청소가 이미 되었거나 벽인 경우, 바라보는 방향을 유지한 채로 한 칸 후진하고 2번으로 되돌아감
			x += dx[back];
			y += dy[back];
		}

	}

}
