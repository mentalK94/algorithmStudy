/**
 * Backjoon - 16234. 인구 이동
 * 인구이동_16234.java
 * @date 2020-12-22
 * @author hansolKim
 **/

package p16000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_16234 {

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean isMove;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N 크기 입력
		L = Integer.parseInt(st.nextToken()); // L 크기 입력
		R = Integer.parseInt(st.nextToken()); // R 크기 입력
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		while(true) {
			isMove = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						bfs(i, j);
					}
				}
			}	
			
			if(!isMove) { break; } // 인구 이동이 없는 경우
			cnt++;
		}
		
		System.out.println(cnt);
		br.close();

	}

	private static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> saveQueue = new LinkedList<>();
		q.add(new int[] {x, y});
		saveQueue.add(new int[] {x, y});
		visited[x][y] = true;
		int people = 0;
		
		while(!q.isEmpty()) {
			int curX = q.peek()[0];
			int curY = q.poll()[1];
			people += map[curX][curY];
			
			for(int i=0; i<4; i++) {
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
				
				int dist = Math.abs(map[curX][curY] - map[nx][ny]);
				if(dist < L || dist > R) continue;
				
				// 범위안에 있는 경우
				visited[nx][ny] = true;
				saveQueue.add(new int[] {nx, ny});
				q.add(new int[] {nx, ny});
			}
		}
		
		if(people != map[x][y]) {
			isMove = true; // 인구이동이 있었음을 표기
			int movePeople = people/saveQueue.size(); 
			while(!saveQueue.isEmpty()) {
				int mx = saveQueue.peek()[0];
				int my = saveQueue.poll()[1];
				
				map[mx][my] = movePeople;
			}
		}
	}

}
