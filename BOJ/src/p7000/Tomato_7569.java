/**
 * Backjoon - 7569. 토마토
 * Tomato_7569.java
 * @date 2020-11-05
 * @author hansolKim
 **/

package p7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7569 {
	
	static int N, M, H, notRipenTomatoCnt; // 익어야하는 토마토 수
	static int[][][] map;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static ArrayList<int[]> tomatos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		tomatos = new ArrayList<>();
		notRipenTomatoCnt = 0; // 익어야하는 토마토 수
		
		boolean isNotRipen = false; // 익지 않은 토마토가 있는지 여부
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) {
						tomatos.add(new int[] {i, j, k});
					}
					if(map[i][j][k]==0) {
						notRipenTomatoCnt++;
						isNotRipen = true;
					}
				}
			}
		}
		
		// 모든 토마토가 익어있는 상태인 경우
		if(!isNotRipen) {
			System.out.println(0);
			return;
		}
		
		// 토마토 익는과정 확인
		int result = bfs();
		System.out.println(result);
		br.close();
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<tomatos.size(); i++) {
			int h = tomatos.get(i)[0];
			int x = tomatos.get(i)[1];
			int y = tomatos.get(i)[2];
			q.add(new int[] {h, x, y, 0});
		}
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			
			int z = info[0];
			int x = info[1];
			int y = info[2];
			int cnt = info[3];
			
			for(int i=0; i<6; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H || map[nz][nx][ny] != 0) continue;
				
				map[nz][nx][ny] = 1; // 토마토가 익음
				notRipenTomatoCnt--;
				
				if(notRipenTomatoCnt == 0) { return cnt+1;}
				q.add(new int[] {nz, nx, ny, cnt+1});
			}
		}
		
		return -1;
	}

}
