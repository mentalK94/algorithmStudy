/**
 * Samsung SW Expert - 5653. 줄기세포 배양
 * Stemcell_5653.java
 * @date 2020-09-03
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Stemcell_5653 {

	private static int[][] map; // map에서 true된곳은 줄기세포가 있는 곳
	private static boolean[][] visited;
	private static int N, M, K;
	private static StringBuilder sb;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static final int INACTIVE = 2;
	private static final int ACTIVE = 1;
	private static final int DEATH = 0;
	private static Queue<Cell> cells;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

		for (int test_case = 1; test_case <= T; test_case++) {

			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로열의 크기 1~50
			M = Integer.parseInt(st.nextToken()); // 세로열의 크기 1~50
			K = Integer.parseInt(st.nextToken()); // 배양시간 1~300

			map = new int[N + K + 2][M + K + 2];
			visited = new boolean[N + K + 2][M + K + 2];
			cells = new LinkedList<>();

			int start = K/2 + 1;

			for (int i = start; i < N+start; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = start; j < start + M; j++) {
					int time = Integer.parseInt(st.nextToken());
					if( time != 0) {
						map[i][j] = time;
						cells.add(new Cell(i, j, time));
						visited[i][j] = true;
					}
				}
			}

			int result = bfs();

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static int bfs() {
		while(K-->0) {
			// 현재 큐의 크기만큼 큐에 들어있는 모든 셀중에 활성화인 셀의 인접칸에 세포 확산
			for(Cell cell : cells) {
				if(cell.getStatus() == ACTIVE) { // 활성화 셀은 세포확산
					for(int i=0; i<4; i++) {
						int nx = cell.getX() + dx[i];
						int ny = cell.getY() + dy[i];
						
						if(!visited[nx][ny] && map[nx][ny] < cell.getTime()) { // 방문하지 않았고, 생명력이 더 큰 값이라면
							map[nx][ny] = cell.getTime();
						}
					}
				}
			}
			
			int size = cells.size();
			for(int t=0; t<size; t++) {
				Cell cell = cells.poll(); // 큐에 있는 내용을 꺼냄
				if(cell.getStatus() == ACTIVE) {
					for(int i=0; i<4; i++) {
						int nx = cell.getX() + dx[i];
						int ny = cell.getY() + dy[i];
						
						if(!visited[nx][ny]) { // 방문하지 않았으면
							cells.add(new Cell(nx, ny, map[nx][ny]));							
							visited[nx][ny] = true;
						}
					}
				}
				cell.next();
				if(cell.getStatus() != DEATH) {
					cells.add(cell);
				}
			}
		}
		return cells.size();
	}

	static class Cell {
		int x;
		int y;
		int time; // 생명력
		int remainTime; // 남은시간
		int status;

		public Cell(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.remainTime = time;
			this.status = INACTIVE;
		}

		public void next() {
			remainTime--;
			if(remainTime > 0) return;
			if(status == INACTIVE) {
				status = ACTIVE;
				remainTime = time;
			}
			else if(status == ACTIVE) {
				status = DEATH;
			}
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getTime() {
			return time;
		}

		public int getStatus() {
			return status;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getRemainTime() {
			return remainTime;
		}

	}

}
