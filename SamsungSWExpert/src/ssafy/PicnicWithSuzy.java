/**
 * Samsung SW Expert
 * 수지의 수지 맞는 여행
 * PicnicWithSuzy.java
 * @date 2020-08-24
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PicnicWithSuzy {
	
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int answer = 0;
	private static char[][] map;
	private static int R, C;
	private static boolean[] isVisited;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			answer = 0;

			map = new char[R][];
			
			for(int i=0; i<R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			isVisited = new boolean['Z'+1];
			
			// 시작점 지정
			// 방문체크
			isVisited[map[0][0]] = true;
			// dfs출발
			answer++;
			dfs(0, 0, 1);
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	/** 
	 * @param x : r
	 * @param y : c
	 * @param step : 현재까지 진행한 칸수 
	 * */
	private static void dfs(int x, int y, int step) {
		System.out.println(x +" " + y);
		
		if(answer == 26) return;
		if(answer < step) { answer = step; }
		
		for(int i=0; i<4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			
			if(!isInMap(rx, ry)) { continue; } // 탈출
			
			if(!isVisited[map[rx][ry]]) {
				isVisited[map[rx][ry]] = true;
				dfs(rx, ry, step+1);
				isVisited[map[rx][ry]] = false;
			}
		}
	}

	private static boolean isInMap(int rx, int ry) {
		return (rx>=0 && rx<R && ry>=0 && ry<C);
	}

}
