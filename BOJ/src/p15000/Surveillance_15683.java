/**
 * Backjoon - 15683. 감시
 * Surveillance_15683.java
 * @date 2020-11-05
 * @time 14:24 ~ 15:16
 * @author hansolKim
 **/

package p15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Surveillance_15683 {

	static int N, M, answer;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] rotate = {-1, 4, 2, 4, 4, 1};
	static int[][] map;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					list.add(new int[] { i, j });
				}
			}
		}

		answer = Integer.MAX_VALUE;
		surveillance(map, 0);
		
		System.out.println(answer);
		br.close();
	}

	private static void surveillance(int[][] map, int cnt) {
		if (cnt == list.size()) {
			int tempAnswer = getAnswer(map);
			answer = tempAnswer < answer ? tempAnswer : answer;
			return;
		}

		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			tempMap[i] = map[i].clone();
		}

		int curX = list.get(cnt)[0];
		int curY = list.get(cnt)[1];
		int cctv = map[curX][curY];

		for(int i=0; i<rotate[cctv]; i++) {
			doSurveillance(tempMap, cctv, i, curX, curY);
			surveillance(tempMap, cnt+1);
			for (int j = 0; j < N; j++) {
				tempMap[j] = map[j].clone();
			}
		}
	}

	private static void doSurveillance(int[][] map, int cctv, int dir, int x, int y) {
		switch (cctv) {
		case 1: // 한방향만 호출
			move(map, x, y, dir);
			break;
		case 2: // 양방향 호출
			move(map, x, y, dir);
			move(map, x, y, dir+2);
			break;
		case 3: // 직각방향 호출 
			move(map, x, y, dir);
			move(map, x, y, dir+1);
			break;
		case 4: // 3방향 호출			
			move(map, x, y, dir);
			move(map, x, y, dir+1);
			move(map, x, y, dir+3);
			break;
		case 5: // 4방향 호출
			for(int i=0; i<4; i++) {
				move(map, x, y, i);
			}
			break;

		}
	}

	private static void move(int[][] map, int x, int y, int dir) { // dir 상우하좌(0123) 순서
		dir %= 4;
		while(true) {
			x += dx[dir];
			y += dy[dir];
			// 영역 밖이거나 벽인 경우
			if(x<0 || x>=N || y<0 || y>=M || map[x][y] == 6) { return; }
			
			// 카메라인 경우
			if(map[x][y] > 0) { continue; }
			
			// 감시영역이 되는 경우
			map[x][y] = -1;
		}
	}

	private static int getAnswer(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
