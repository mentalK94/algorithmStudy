/**
 * Samsung SW Expert - 7793. 오! 나의 여신님
 * ParenthesisMating.java
 * @date 2020-08-27
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int sec;
	boolean devil; // 악마인지 수연인지 구분

	public Point(int x, int y, int sec, boolean devil) {
		this.x = x;
		this.y = y;
		this.sec = sec;
		this.devil = devil;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSec() {
		return sec;
	}

	public boolean isDevil() {
		return devil;
	}
}

public class OhMyPrincess_7793 {

	private static int N, M;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int sX, sY; // 수연의 위치
	private static int dX, dY; // 여신의 위치
	private static List<Point> devilList;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			sb.append("#").append(test_case).append(" ");

			StringTokenizer data = new StringTokenizer(br.readLine());

			N = Integer.parseInt(data.nextToken());
			M = Integer.parseInt(data.nextToken());

			map = new char[N][];
			visited = new boolean[N][M];
			devilList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'D') {
						dX = i;
						dY = j;
						continue;
					}
					if (map[i][j] == 'S') {
						sX = i;
						sY = j;
						map[i][j] = '.';
						continue;
					}
					if (map[i][j] == '*') {
						devilList.add(new Point(i, j, 0, true));
					}
				}
			}

			game(); // bfs로 구현
		}

		System.out.println(sb);

	}

	private static void game() {

		Queue<Point> q = new LinkedList<>();

		visited[sX][sY] = true;

		// 1. 악마의 리스트 삽입
		for (int i = 0; i < devilList.size(); i++) {
			q.offer(devilList.get(i));
		}

		// 2. 수연의 위치 삽입
		q.offer(new Point(sX, sY, 0, false));

		while (!q.isEmpty()) {

			// 1. queue에서 악마 리스트를 꺼내서 진행
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int rx = p.getX() + dx[i];
				int ry = p.getY() + dy[i];

				if (rx < 0 || rx >= N || ry < 0 || ry >= M)
					continue; // 이동할 수 없는 칸인 경우

				if (p.isDevil() && map[rx][ry] == '.') { // devil인 경우
					map[rx][ry] = '*'; // 흑화 표기
					q.offer(new Point(rx, ry, p.getSec() + 1, p.isDevil()));
				} else if (!p.isDevil() && !visited[rx][ry] && (map[rx][ry] == '.' || map[rx][ry] == 'D')) { // 수연인 경우
					
					if(map[rx][ry] == 'D') {
						sb.append(p.getSec()+1).append("\n");
						return;
					}
					
					visited[rx][ry] = true;
					q.offer(new Point(rx, ry, p.getSec() + 1, p.isDevil()));
				}
			}
		}

		sb.append("GAME OVER").append("\n");

	}

}
