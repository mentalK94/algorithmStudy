/**
 * Backjoon - 3109. 빵집
 * Bakery_3109.java
 * @date 2020-08-27
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakery_3109 {

	private static int[][] map;
	private static int[] dx = { -1, 0, 1 };
	private static int[] dy = { 1, 1, 1 };
	private static int R, C; // R : 행 수, C : 열 수
	private static int answer = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer init = new StringTokenizer(br.readLine());

		R = Integer.parseInt(init.nextToken());
		C = Integer.parseInt(init.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {

			String[] data = br.readLine().split("");

			for (int j = 0; j < C; j++) {
				if (data[j].equals(".")) {
					map[i][j] = 0;
				} else { // 건물이 있는 경우
					map[i][j] = 1;
				}
			}
		}

		int step = 2;

		for (int i = 0; i < R; i++) {
			getPipeline(i, 0, step++);
		}

		for (int t = 0; t < R; t++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[t][j]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println(answer);
	}

	private static void getPipeline(int x, int y, int step) {

		// 1. 유도조건 ---> 맨 오른쪽인 식당에 도착한 경우
		if (y == C - 1) {
			System.out.println(x + " " + y);
			answer++;
			return;
		}

		// 2. 기저조건
		for (int i = 0; i < 3; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];

			if (rx < 0 || rx >= R) { // ry는 검사할 필요가 없다.
				continue;
			}

			if (map[rx][ry] == 0) { // 갈 수 있는 곳인 경우
				map[rx][ry] = step;
				getPipeline(rx, ry, step);
				break;
			}

		}
	}

}
