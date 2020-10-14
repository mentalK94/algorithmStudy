/**
 * Backjoon - 14502. 연구소
 * Research_14502.java
 * @date 2020-10-15
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Research_14502 {

	static int N, M, answer, n, r;
	static int[][] map;
	static ArrayList<int[]> virusList, emptyList;
	static int[] selected;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		virusList = new ArrayList<>(); // 바이러스 위치
		emptyList = new ArrayList<>(); // 빈 공간의 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) { emptyList.add(new int[] {i, j}); }
				if(map[i][j] == 2) { virusList.add(new int[] {i, j}); }
			}
		}
		
		n = emptyList.size();
		r = 3;
		selected = new int[3];
		
		combination(0, 0);
		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		if(cnt == r) {
			
			int[][] temp = new int[N][M];
			for(int i=0; i<N; i++) { temp[i] = map[i].clone(); }
			
			for(int i=0; i<selected.length; i++) {
				int[] xy = emptyList.get(selected[i]);
				temp[xy[0]][xy[1]] = 1; // 벽 설치
			}
			
			bfs(temp);
			
			int tempAnswer = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp[i][j] == 0) { tempAnswer++; }
				}
			}
			if(answer < tempAnswer) {
				answer = tempAnswer;
			}
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static void bfs(int[][] map) {
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<virusList.size(); i++) {
			q.add(new int[] {virusList.get(i)[0], virusList.get(i)[1]});
		}
		
		while(!q.isEmpty()) {
			
			int[] xy = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				
				// 영역 밖으로 벗어나거나 빈 공간이 아닌경우
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]!=0) continue;
				
								
				map[nx][ny] = 2;
				q.add(new int[] {nx, ny});
			}
		}
		
	}
}