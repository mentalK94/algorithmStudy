/**
 * Samsung SW Expert - 1249. 보급로
 * SupplyRoute_1249.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SupplyRoute_1249 {

	static int N, answer;
	static int[][] map, cost;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static final int INF = 1000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			answer = 0;
			map = new int[N][N];
			cost = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cost[i][j] = INF;
				}
			}
			
			bfs();
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(cost[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			answer = cost[N-1][N-1];
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		
		cost[0][0] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				if(cost[x][y]+map[nx][ny]<cost[nx][ny]) {
					cost[nx][ny] = cost[x][y]+map[nx][ny];
					q.add(new int[] {nx, ny});
				}
			}
			
		}
		
	}

}