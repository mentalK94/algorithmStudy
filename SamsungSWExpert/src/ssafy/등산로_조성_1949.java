/**
 * Samsung SW Expert - 1949. 등산로 조성
 * 등산로_조성_1949.java
 * @date 2021-03-11
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등산로_조성_1949 {

	static int answer, N, K, top;
	static int[][] map;
	static Queue<int[]> topList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; ++tc) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			top = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = top < map[i][j] ? map[i][j] : top;
				}
			}
			
			topList = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == top) {
						topList.add(new int[] {i, j});
					}					
				}
			}
			
			answer = 0;			
			while(!topList.isEmpty()) {
				int x = topList.peek()[0];
				int y = topList.poll()[1];
				visited = new boolean[N][N];
				visited[x][y] = true;
				searchLoad(x, y, 1, top, false);
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void searchLoad(int x, int y, int dist, int curH, boolean use) {
		answer = answer > dist ? answer : dist;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
			
			if(curH > map[nx][ny]) {
				visited[nx][ny] = true;
				searchLoad(nx, ny, dist+1, map[nx][ny], use);
				visited[nx][ny] = false;
			} else {
				if(use || map[nx][ny]-K >= curH) continue;
				
				use = true;
				visited[nx][ny] = true;
				searchLoad(nx, ny, dist+1, curH-1, use);
				use = false;
				visited[nx][ny] = false;
			}
		}
	}
}