/**
 * Backjoon - 1080. 행렬
 * 행렬_1080.java
 * @date 2021-02-24
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_1080 {

	static int N, M;
	static int[][] map, answerMap;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		answerMap = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = data.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<M; j++) {
				answerMap[i][j] = data.charAt(j)-'0';
			}
		}
		
		int cnt = 0;
		
		for(int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-3; j++) {
				
				// 이미 이 칸을 바꾼 적이 있는 경우
				if(map[i][j] == answerMap[i][j] || visited[i][j]) {	continue; }
				
				// 바꾼 적 없는 경우 -> 바꾸고 처음부터 다시 비교
				changeMap(i, j);
				visited[i][j] = true;
				cnt++;
				i = 0; 
				j = -1;
				
			}
		}
		
		boolean isPossible = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != answerMap[i][j]) {
					isPossible = false;
					break;
				}
			}
		}
		
		cnt = isPossible ? cnt : -1;
		
		System.out.println(cnt);
		br.close();
		
	}

	private static void changeMap(int x, int y) {
		for(int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				map[i][j] = map[i][j] == 0 ? 1 : 0;
			}
		}
	}
}