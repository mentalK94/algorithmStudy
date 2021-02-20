package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비숍_1799 {
	
	static int N, answer;
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1};
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		
		putBishop(0,0,0,map);
		
		System.out.println(answer);
		br.close();
	}

	private static void putBishop(int x, int y, int cnt, int[][] map2) {
		
		// 현재위지 놓을 수 없는 부분인 경우
		if(map2[x][y] == 0) {
			if(x == N-1 && y == N-1) {
				answer = answer < cnt ? cnt : answer;
				return;
			}
			if(y == N-1) {
				putBishop(x+1, 0, cnt, map2);
			} else {
				putBishop(x, y+1, cnt, map2);
			}
			return;
		}
		
		// 놓을 수 있는 경우
		int[][] tempMap = new int[N][N];
		
		// 맵 복사
		for(int i=0; i<N; i++) {
			tempMap[i] = map2[i].clone();
		}
		
		// 놓는 경우				
		bfs(x, y, tempMap);
		putBishop(x, y, cnt+1, tempMap);
		
		// 놓지 않는 경우
		if(x == N-1 && y == N-1) {
			answer = answer < cnt ? cnt : answer;
			return;
		}
		if(y == N-1) {
			putBishop(x+1, 0, cnt, map2);
		} else {
			putBishop(x, y+1, cnt, map2);
		}
	}

	private static void bfs(int x, int y, int[][] map) {
		
		boolean[][] visited = new boolean[N][N];
		
		Queue<int[]> q = new LinkedList<>();		
		
		for(int i=0; i<4; i++) {
			q.add(new int[] {x, y, i});
		}
		map[x][y] = 0;
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int curX = q.peek()[0];
			int curY = q.peek()[1];
			int dir = q.poll()[2];
			
			int nx = curX + dx[dir];
			int ny = curY + dy[dir];
			
			if(nx < 0 || nx >=N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			
			map[nx][ny] = 0;
			visited[nx][ny] = true;
			q.add(new int[] {nx, ny, dir});
		}
	}
}