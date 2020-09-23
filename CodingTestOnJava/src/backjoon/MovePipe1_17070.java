/**
 * Backjoon - 17070. 파이프 옮기기 1
 * MovePipe1_17070.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePipe1_17070 {

	static int N;
	static int[][] map;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());
				// if(info == 1) { info *= -1;}
				map[i][j] = info;
			}
		}
		
		dfs(0, 1, 0);
		
		System.out.println(answer);
	}
	private static void dfs(int x, int y, int dir) { // dir: 0=가로, 1=세로, 2=대각선
		
		if(x == N-1 && y == N-1) {
			answer++;
			return;
		}
		
		for(int i=0; i<3; i++) {
			
			// 가로상태에서 세로로 이동할 수 없고, 세로상태에서 가로로 이동할 수 없다
			if(dir==0 && i==1 || dir==1 && i==0) continue;
			
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			// 영역 밖으로 벗어났거나 벽돌인 경우 경우
			if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny] == 1) continue;
			
			// 대각선인경우 왼쪽과 윗쪽이 벽돌인지도 확인해야 한다
			if(i==2 && (map[nx][ny-1] == 1 || map[nx-1][ny] == 1)) continue;
			
			dfs(nx, ny, i);
		}
		
	}

}
