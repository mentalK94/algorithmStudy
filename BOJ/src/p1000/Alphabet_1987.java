/**
 * Backjoon - 1987. 알파벳
 * Alphabet_1987.java
 * @date 2020-08-27
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet_1987 {

	private static int N, M;
	private static char[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static boolean[] isVisited;
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer data = new StringTokenizer(br.readLine());

		N = Integer.parseInt(data.nextToken());
		M = Integer.parseInt(data.nextToken());

		map = new char[N][];
		isVisited = new boolean['Z' + 1];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		answer++;
		isVisited[map[0][0]] = true;
		dfs(0, 0, 1);

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int step) {

		if (answer == 26)
			return;
		if (answer < step) {
			answer = step;
		}

		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];

			if (rx < 0 || rx >= N || ry < 0 || ry >= M || isVisited[map[rx][ry]])
				continue;

			isVisited[map[rx][ry]] = true;
			dfs(rx, ry, step + 1);
			isVisited[map[rx][ry]] = false;

		}

	}

}
