/**
 * Backjoon - 2206. 벽 부수고 이동하기
 * MoveBreakWall_2206.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int step;
	int isBreak; // 0이면 아직 부수지 않은 것, 1이면 부순것

	public Point(int x, int y, int step, int isBreak) {
		this.x = x;
		this.y = y;
		this.step = step;
		this.isBreak = isBreak;
	}
}

public class MoveBreakWall_2206 {

	private static int[][] map;
	private static boolean[][][] isVisited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer init = new StringTokenizer(br.readLine());

		N = Integer.parseInt(init.nextToken());
		M = Integer.parseInt(init.nextToken());

		map = new int[N][M];
		isVisited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String[] data = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}

		isVisited[0][0][0] = true; // 벽을 부수지 않은 상태에서 (0, 0) 방문 표기
		move(0, 0, 1, 0);

	}

	private static void move(int x, int y, int step, int isBreak) {

		Queue<Point> pointList = new LinkedList<>();

		pointList.add(new Point(x, y, step, isBreak));

		while (!pointList.isEmpty()) {
			Point p = pointList.poll();

			if ((p.x == N - 1) && (p.y == M - 1)) { // 마지막에 도달한 경우
				System.out.println(p.step);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];

				if ((x < 0 || x >= N || y < 0 || y >= M)) { // 영역안에 존재하지 않은 경우
					continue;
				}
				
				if (map[rx][ry] == 0 && !isVisited[rx][ry][p.isBreak]) { // 벽이 없고 이전에 방문하지 않은 경우
					pointList.add(new Point(rx, ry, p.step + 1, p.isBreak));
					isVisited[rx][ry][p.isBreak] = true; // 방문 표기
				} else { // 벽이 존재하는 경우
					if (p.isBreak == 0 && !isVisited[rx][ry][p.isBreak]) { // 벽을 부순적이 없고 방문하지 않은 경우
						pointList.add(new Point(rx, ry, p.step + 1, 1)); // 벽을 부순 것으로 변경
						isVisited[rx][ry][1] = true; // 벽을 부순 곳에서 방문 표기
					}
				}

			}
		}

		System.out.println(-1);

	}
}
