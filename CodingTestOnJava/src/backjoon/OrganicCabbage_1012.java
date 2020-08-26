/**
 * Backjoon - 1012. 유기농 배추
 * OrganicCabbage_1012.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {

	private static int[][] map;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int M, N, K; // 가로길이, 세로길이, 배추의 갯수
	private static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		
		for(int test_cast=0; test_cast<T; test_cast++) {
			
			StringTokenizer init = new StringTokenizer(br.readLine());
			M = Integer.parseInt(init.nextToken());
			N = Integer.parseInt(init.nextToken());
			K = Integer.parseInt(init.nextToken());
			
			map = new int[N][M];
			
			
			/* 배추 위치 입력 */
			for(int i=0; i<K; i++) {
				init = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(init.nextToken());
				int x = Integer.parseInt(init.nextToken());
				map[x][y] = 1;
			}
			
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						dfs(i, j);
						answer++;
					}
				}				
			}
			
			sb.append(answer).append("\n");
		}
		
		
		System.out.println(sb); // 결과 출력
	}

	private static void dfs(int x, int y) {
		map[x][y] = -1;
		
		for(int i=0; i<4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			
			if(isInMap(rx, ry) && map[rx][ry] == 1) {
				dfs(rx, ry);
			}
		}
	}

	private static boolean isInMap(int x, int y) {
		return (x>=0 && x<N && y>=0 && y<M);
	}

}
