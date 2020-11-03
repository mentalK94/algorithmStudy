/**
 * Backjoon - 11724. 연결요소의 개수
 * NumberOfConnectionElements_11724.java
 * @date 2020-09-16
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfConnectionElements_11724 {

	private static int M, N;
	private static int[][] map;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][M+1];
		visited = new boolean[M+1];
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		for(int i=1; i<=M; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1; i<=M; i++) {
			if(!visited[i] && map[x][i] == 1) {
				dfs(i);
			}
		}
	}

}
