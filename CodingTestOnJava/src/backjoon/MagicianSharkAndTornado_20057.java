/**
 * Backjoon - 20057. 마법사상어와 토네이도
 * MagicianSharkAndTornado_20057.java
 * @date 2020-10-21
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicianSharkAndTornado_20057 {

	static int[][] map;
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		answer = 0;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate();
		System.out.println(answer);
	}

	private static void rotate() {
		int x = N / 2;
		int y = N / 2;

		// 왼쪽으로 모래 이동
		leftSand(x, y - 1);
		y--;

		int term = 2;

		while (true) {
			for (int i = 0; i < term - 1; i++) {
				x++;
				downSand(x, y);
			}
			for (int i = 0; i < term; i++) {
				y++;
				rightSand(x, y);
			}
			for (int i = 0; i < term; i++) {
				x--;
				upSand(x, y);
			}
			for (int i = 0; i < term+1; i++) {
				y--;
				leftSand(x, y);
				if(x==0 && y==0) {return;}
			}

			term += 2;
		}

	}

	private static void leftSand(int x, int y) {
		int[] dx = { -1, 1, -2, 2, 0, -1, 1, -1, 1 };
		int[] dy = { 1, 1, 0, 0, -2, 0, 0, -1, -1 };

		int sand = map[x][y]; // 현재 없어질 모래 양
		int tempSand = sand;
		map[x][y] = 0;

		for (int i = 0; i < 9; i++) {

			int curSand = 0;

			// 1%칸 처리
			if (i <= 1) {
				curSand = (int) Math.floor((double) sand * 0.01);
				tempSand -= curSand;
			}

			// 2%칸 처리
			if (i > 1 && i <= 3) {
				curSand = (int) Math.floor((double) sand * 0.02);
				tempSand -= curSand;
			}

			// 5%칸 처리
			if (i == 4) {
				curSand = (int) Math.floor((double) sand * 0.05);
				tempSand -= curSand;
			}

			// 7%칸 처리
			if (i > 4 && i <= 6) {
				curSand = (int) Math.floor((double) sand * 0.07);
				tempSand -= curSand;
			}

			// 10%칸 처리
			if (i > 6 && i <= 8) {
				curSand = (int) Math.floor((double) sand * 0.1);
				tempSand -= curSand;
			}

			int nx = x + dx[i];
			int ny = y + dy[i];

			// 영역 밖으로 벗어난 경우
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				answer += curSand;
			} else {
				map[nx][ny] += curSand;
			}
		}

		if (x < 0 || x >= N || y - 1 < 0 || y - 1 >= N) {
			answer += tempSand;
		} else {
			map[x][y - 1] += tempSand;
		}
	}

	private static void rightSand(int x, int y) {
		int[] dx = { -1, 1, -2, 2, 0, -1, 1, -1, 1 };
		int[] dy = { -1, -1, 0, 0, 2, 0, 0, 1, 1 };

		int sand = map[x][y]; // 현재 없어질 모래 양
		int tempSand = sand;
		map[x][y] = 0;

		for (int i = 0; i < 9; i++) {

			int curSand = 0;

			// 1%칸 처리
			if (i <= 1) {
				curSand = (int) Math.floor((double) sand * 0.01);
				tempSand -= curSand;
			}

			// 2%칸 처리
			if (i > 1 && i <= 3) {
				curSand = (int) Math.floor((double) sand * 0.02);
				tempSand -= curSand;
			}

			// 5%칸 처리
			if (i == 4) {
				curSand = (int) Math.floor((double) sand * 0.05);
				tempSand -= curSand;
			}

			// 7%칸 처리
			if (i > 4 && i <= 6) {
				curSand = (int) Math.floor((double) sand * 0.07);
				tempSand -= curSand;
			}

			// 10%칸 처리
			if (i > 6 && i <= 8) {
				curSand = (int) Math.floor((double) sand * 0.1);
				tempSand -= curSand;
			}

			int nx = x + dx[i];
			int ny = y + dy[i];

			// 영역 밖으로 벗어난 경우
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				answer += curSand;
			} else {
				map[nx][ny] += curSand;
			}
		}

		if (x < 0 || x >= N || y+1 < 0 || y+1 >= N) {
			answer += tempSand;
		} else {
			map[x][y + 1] += tempSand;
		}
	}

	private static void upSand(int x, int y) {
		int[] dx = { 1, 1, 0, 0, -2, 0, 0, -1, -1 };
		int[] dy = { -1, 1, -2, 2, 0, -1, 1, -1, 1 };

		int sand = map[x][y]; // 현재 없어질 모래 양
		int tempSand = sand;
		map[x][y] = 0;

		for (int i = 0; i < 9; i++) {

			int curSand = 0;

			// 1%칸 처리
			if (i <= 1) {
				curSand = (int) Math.floor((double) sand * 0.01);
				tempSand -= curSand;
			}

			// 2%칸 처리
			if (i > 1 && i <= 3) {
				curSand = (int) Math.floor((double) sand * 0.02);
				tempSand -= curSand;
			}

			// 5%칸 처리
			if (i == 4) {
				curSand = (int) Math.floor((double) sand * 0.05);
				tempSand -= curSand;
			}

			// 7%칸 처리
			if (i > 4 && i <= 6) {
				curSand = (int) Math.floor((double) sand * 0.07);
				tempSand -= curSand;
			}

			// 10%칸 처리
			if (i > 6 && i <= 8) {
				curSand = (int) Math.floor((double) sand * 0.1);
				tempSand -= curSand;
			}

			int nx = x + dx[i];
			int ny = y + dy[i];

			// 영역 밖으로 벗어난 경우
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				answer += curSand;
			} else {
				map[nx][ny] += curSand;
			}
		}

		if (x-1 < 0 || x-1 >= N || y < 0 || y >= N) {
			answer += tempSand;
		} else {
			map[x-1][y] += tempSand;
		}
	}

	private static void downSand(int x, int y) {
		int[] dx = { -1, -1, 0, 0, 2, 0, 0, 1, 1 };
		int[] dy = { -1, 1, -2, 2, 0, -1, 1, -1, 1 };

		int sand = map[x][y]; // 현재 없어질 모래 양
		int tempSand = sand;
		map[x][y] = 0;

		for (int i = 0; i < 9; i++) {

			int curSand = 0;

			// 1%칸 처리
			if (i <= 1) {
				curSand = (int) Math.floor((double) sand * 0.01);
				tempSand -= curSand;
			}

			// 2%칸 처리
			if (i > 1 && i <= 3) {
				curSand = (int) Math.floor((double) sand * 0.02);
				tempSand -= curSand;
			}

			// 5%칸 처리
			if (i == 4) {
				curSand = (int) Math.floor((double) sand * 0.05);
				tempSand -= curSand;
			}

			// 7%칸 처리
			if (i > 4 && i <= 6) {
				curSand = (int) Math.floor((double) sand * 0.07);
				tempSand -= curSand;
			}

			// 10%칸 처리
			if (i > 6 && i <= 8) {
				curSand = (int) Math.floor((double) sand * 0.1);
				tempSand -= curSand;
			}

			int nx = x + dx[i];
			int ny = y + dy[i];

			// 영역 밖으로 벗어난 경우
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				answer += curSand;
			} else {
				map[nx][ny] += curSand;
			}
		}

		if (x+1 < 0 || x+1 >= N || y < 0 || y >= N) {
			answer += tempSand;
		} else {
			map[x+1][y] += tempSand;
		}
	}

}
