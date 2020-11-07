/**
 * Samsung SW Expert - 1868. 파핑파핑 지뢰찾기
 * Minesweeper_1868.java
 * @date 2020-11-05
 * @time 16:40 ~ 18:00
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper_1868 {

	static int N;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static char[][] map;
	static ArrayList<int[]> notMineList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			notMineList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && !isMine(i, j)) { // 지뢰가 없는 경우
						notMineList.add(new int[] { i, j });
						map[i][j] = '@'; // 0인 곳 '@'표기
					}
				}
			}

			int answer = 0;
			
			// 일단 0인 칸만 터뜨림
			answer += click();
			answer += remainClick();

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int remainClick() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '.') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int click() {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<notMineList.size(); i++) {
			
			int curX = notMineList.get(i)[0];
			int curY = notMineList.get(i)[1];
			
			// 이미 터져있는 곳이면 패스
			if(map[curX][curY] == '#') {continue;}
			
			cnt++; // 클릭횟수 추가
			
			q.add(new int[] {curX, curY});
			
			// 현재 위치를 기반으로 8방 터뜨림
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int x = info[0];
				int y = info[1];
				
				map[x][y] = '#';
				
				for(int j=0; j<8; j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					
					// 영역 밖이거나 지뢰가 있는 칸이거나 이미 터져있는 경우 패스
					if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny] == '*' || map[nx][ny] == '#') continue;
					
					// '@'인 0인 곳을 만난 경우
					if(map[nx][ny] == '@') {
						q.add(new int[] {nx, ny});
					}
						
					map[nx][ny] = '#'; // 클릭처리
				}
			}
		}
		return cnt;
	}

	// 지뢰가 하나도 없는 지 확인
	private static boolean isMine(int x, int y) {

		boolean isMine = false;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 영역 밖이거나 빈 공간이면 패스
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != '*')
				continue;

			// 지뢰가 있는 경우
			isMine = true;
			break;
		}

		return isMine;
	}
}