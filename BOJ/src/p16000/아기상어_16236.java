/**
 * Backjoon - 16236. 아기 상어
 * 아기상어_16236.java
 * @date 2020-12-22
 * @author hansolKim
 **/

package p16000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {

	static int N;
	static int[][] map, dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int sharkX, sharkY, sharkSize, eatCnt;
	static PriorityQueue<int[]> fishes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fishes = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[3] == o2[3]) { // 거리가 같을 때
					if(o1[0] == o2[0]) { // 위에 있는 물고기가 여러 개 일때
						return Integer.compare(o1[1], o2[1]); // 가장 왼쪽에 있는 물고기부터
					}
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[3], o2[3]);
			}
		});

		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					sharkSize = 2;
					map[i][j] = 0;
					continue;
				}
				if(map[i][j] != 0) {
					fishes.add(new int[] {i, j, map[i][j], 0}); // 물고기의 위치, 크기, 상어와의 거리
				}
			}
		}
		
		int time = 0;

		Queue<int[]> temp = new LinkedList<>();
		while(true) {
			
			dist = new int[N][N];		
			if(fishes.isEmpty()) { break;}
			
			// 상어와 물고기 거리계산
			bfs();
			
			while(!fishes.isEmpty()) {
				int x = fishes.peek()[0];
				int y = fishes.peek()[1];
				int size = fishes.poll()[2];
				dist[x][y] = dist[x][y]==0 ? Integer.MAX_VALUE : dist[x][y];
				temp.add(new int[] {x, y, size, dist[x][y]});
			}
			
			while(!temp.isEmpty()) {
				fishes.add(temp.poll());
			}
			
			boolean isEat = false;
			
			while(!fishes.isEmpty()) {
				int x = fishes.peek()[0];
				int y = fishes.peek()[1];
				int size = fishes.peek()[2];
				int distance = fishes.poll()[3];
				if(distance == Integer.MAX_VALUE) { break; }
				
				if(sharkSize <= size) {
					temp.add(new int[] {x, y, size, distance});
					continue;
				}
				
				// 상어가 물고기를 먹음
				isEat = true;
				time += distance;
				sharkX = x;
				sharkY = y;
				if(++eatCnt == sharkSize) { 
					sharkSize++;
					eatCnt = 0;
				}
				map[x][y] = 0;
				break;
			}
			
			while(!temp.isEmpty()) {
				fishes.add(temp.poll());
			}
			
			if(!isEat) { break;}
		}
		
		System.out.println(time);
		br.close();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sharkX, sharkY, 0});
		dist[sharkX][sharkY] = -1;
		
		while(!q.isEmpty()) {
			int curX = q.peek()[0];
			int curY = q.peek()[1];
			int distance = q.poll()[2];
			
			for(int i=0; i<4; i++) {
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || dist[nx][ny] != 0) continue; // 영역 밖이거나 이미 방문한 경우
				
				// 아기상어가 지나갈 수 없는 물고기인 경우
				if(sharkSize < map[nx][ny]) {
					dist[nx][ny] = distance+1;
					continue;
				}
				
				dist[nx][ny] = distance+1;
				q.add(new int[] {nx, ny, distance+1});
			}
		}
		
	}
}