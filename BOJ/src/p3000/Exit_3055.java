/**
 * Backjoon - 3055. 탈출
 * Exit_3055.java
 * @date 2020-09-04
 * @author hansolKim
 **/

package p3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int x;
	int y;
	int type; // 재우인지 불인지 구분
	int time; // 시간

	public XY(int x, int y, int type, int time) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.time = time;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getType() {
		return type;
	}

	public int getTime() {
		return time;
	}
}

public class Exit_3055 {

	private static int R, C;
	private static int jX, jY; // 재우의 위치
	private static final int FIRE = 0, JAEWOO = 1; // 불을 0으로 재우를 1로 타입 규정
	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<XY> queue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		queue = new LinkedList<XY>();

		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			for (int j = 0; j < C; j++) {
				char state = data.charAt(j);
				map[i][j] = state;

				if (state == '*') { // 불인 경우
					queue.offer(new XY(i, j, FIRE, 0));
				}
				if (state == 'S') { // 재우의 위치인 경우
					jX = i;
					jY = j;
					map[i][j] = '.';
					visited[i][j] = true;
				}
			}
		}

		returnHome(); // 재우가 용사의 집으로 가는 로직 호출
	}

	/* 재우가 용사의 집으로 가는 로직 구현 **/
	private static void returnHome() {

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 1. 재우의 위치 삽입
		queue.offer(new XY(jX, jY, JAEWOO, 0));

		while (!queue.isEmpty()) {

			XY p = queue.poll(); // queue에서 하나 꺼냄

			for (int i = 0; i < 4; i++) {
				int nx = p.getX() + dx[i];
				int ny = p.getY() + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue; // 이동범위를 벗어난 경우

				if (p.getType() == FIRE && map[nx][ny] == '.') { // 현재 p객체가 불이고 비어있는 칸인경우(불을 옮길 수 있는 경우)
					map[nx][ny] = '*';
					queue.offer(new XY(nx, ny, FIRE, p.getTime() + 1));
				}
				/* 현재 p객체가 재우이고 방문하지 않은 칸이며 이동할 수 있는 곳(비어있는 칸이거나 D(용사의 집))인 경우 */
				else if (p.getType() == JAEWOO && !visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
					if (map[nx][ny] == 'D') { // 이동한 칸이 용사의 집인 경우
						System.out.println(p.getTime() + 1);
						return;
					}
					queue.offer(new XY(nx, ny, JAEWOO, p.getTime() + 1)); // 재우가 이동한 새로운 위치 삽입
					visited[nx][ny] = true;
				}
			}

		}

		System.out.println("KAKTUS"); // 불가능한 경우

	}

}
