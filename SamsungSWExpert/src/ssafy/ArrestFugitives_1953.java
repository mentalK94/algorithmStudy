/**
 * Samsung SW Expert - 1953. 탈주범 검거
 * ArrestFugitives_1953.java
 * @date 2020-11-03
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ArrestFugitives_1953 {
	
	static int answer, N, M, holeX, holeY, L; // 지도의 크기, 맨홀의 위치, 탈출 후 소요시간
	static int[][] map;
	static boolean[][] visited;
	static int[][] dx = {{},{-1, 1, 0, 0}, {-1, 1}, {0, 0}, {0, -1}, {0,1},{0,1},{0,-1}};
	static int[][] dy = {{},{0,0,-1,1}, {0,0}, {-1,1}, {1, 0},{1,0},{-1,0},{-1,0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			holeX = Integer.parseInt(st.nextToken());
			holeY = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			answer = getAnswer();
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {holeX, holeY, 1});
		visited[holeX][holeY] = true;
		
		while(!q.isEmpty()) {
			
			int[] curInfo = q.poll();
			int x = curInfo[0]; 
			int y = curInfo[1];
			int t = curInfo[2];
			
			if(t+1>L) { return;}
			
			int type = map[x][y];
			
			for(int i=0; i<dx[type].length; i++) {
				
				int nx = x+dx[type][i];
				int ny = y+dy[type][i];
				
				if(nx<0||nx>=N||ny<0||ny>=M||map[nx][ny]==0||visited[nx][ny]) continue;
				
				// 탐색하고 있는 위치에서도 원래위치로 올 수 있는지 확인
				int searchType = map[nx][ny];
				boolean isConnect = false;
				for(int j=0; j<dx[searchType].length; j++) {
					int sx = nx+dx[searchType][j];
					int sy = ny+dy[searchType][j];
					if(sx == x && sy == y) { 
						isConnect = true;
						break;
					}
				}
				
				// 연결될 수 있는 경우에 방문 처리 및 큐에 추가
				if(isConnect) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, t+1});
				}
			}
			
		}
	}

	private static int getAnswer() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) {cnt++;}
			}
		}
		
		return cnt;
	}

}