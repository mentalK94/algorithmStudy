/**
 * jungol - 1733. 오목
 * Omok_1733.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Omok_1733 {

	private static int[][] baduk;
	private static final int SIZE = 19;

	private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int tempCount = 0;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		baduk = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {

			StringTokenizer info = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				baduk[i][j] = Integer.parseInt(info.nextToken());
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (baduk[j][i] == 1 || baduk[j][i] == 2) {
					dfs(j, i);
					if (sb.length() > 0) {
						System.out.println(sb);
						return;
					}
				}
			}
		}

		System.out.println(0);
	}

	private static void dfs(int x, int y) {

		// 1. 8방 탐색
		for (int i = 0; i < 8; i++) {

			int badukdol = baduk[x][y];
			tempCount = 1;

			int rx = x + dx[i];
			int ry = y + dy[i];

			if (rx < 0 || rx >= SIZE || ry < 0 || ry >= SIZE) {
				continue;
			} // 범위를 벗어난 경우

			if (badukdol == baduk[rx][ry]) { // 같은 돌을 발견한 경우
				int nx = x;
				int ny = y;

				// 현재방향으로 탐색
				while (true) {
					nx += dx[i];
					ny += dy[i];

					if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) {
						break;
					}

					if (badukdol == baduk[nx][ny]) { // 같은 바둑돌인 경우
						tempCount++;
					} else { // 같지 않은 경우
						break;
					}

					if (tempCount > 5) { // 같은 바둑돌이 6개 이상인 경우
						break;
					}
				}

				nx = x;
				ny = y;
				
				// 반대방향으로 탐색
				while (true) {
					nx -= dx[i];
					ny -= dy[i];

					if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) {
						break;
					}

					if (badukdol == baduk[nx][ny]) { // 같은 바둑돌인 경우
						tempCount++;
					} else { // 같지 않은 경우
						break;
					}

					if (tempCount > 5) { // 같은 바둑돌이 6개 이상인 경우
						break;
					}
				}
				
				if (tempCount == 5) {
					sb.append(badukdol).append("\n");
					sb.append(x + 1).append(" ").append(y + 1); // index값이므로 좌표값 표기를 위해 +1
					return;
				}
			}
		}
	}
}
