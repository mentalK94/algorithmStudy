/**
 * Backjoon - 10158. 개미
 * Ant_10158.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ant_10158 {

	static int w, h, p, q, t, cycle;
	static int[][] d = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	static StringBuilder sb;
	static boolean cycleInit = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		t = Integer.parseInt(br.readLine());

		cycle = 0;
		sb = new StringBuilder();
		move(p + 1, q + 1, 0); // 우상:0, 우하:1, 좌상:2, 좌하:3
		br.close();
	}

	private static void move(int x, int y, int dir) {
		t--;
		if(!cycleInit) {
			cycle++;
		}
		
		if(t == 0) {
			sb.append(x).append(" ").append(y);
            System.out.println(sb);
			return;
		}
		
		if (x == p && y == q && dir == 0) { // 다시 맨 처음으로 온 경우
			return;
		}

		// 현재 위치가 우상 꼭지점인 경우 ---> 좌하
		if (x == w && y == h) {
			move(x - 1, y - 1, 3);
			return;
		}

		// 현재 위치가 우하 꼭지점인 경우 ---> 좌상
		if (x == w && y == 0) {
			move(x - 1, y + 1, 2);
			return;
		}

		// 현재 위치가 좌상 꼭지점인 경우 ---> 우하
		if (x == 0 && y == h) {
			move(x + 1, y - 1, 1);
			return;
		}

		// 현재 위치가 좌하 꼭지점인 경우 ---> 우상
		if (x == 0 && y == 0) {
			move(x + 1, y + 1, 0);
			return;
		}

		// 우상 방향에서 우측에 부딪힌 경우 ---> 좌상
		if (dir == 0 && x == w) {
			move(x - 1, y + 1, 2);
			return;
		}

		// 우하 방향에서 우측에 부딪힌 경우 ---> 좌하
		if (dir == 1 && x == w) {
			move(x - 1, y - 1, 3);
			return;
		}

		// 좌상 방향에서 좌측에 부딪힌 경우 ---> 우상
		if (dir == 2 && x == 0) {
			move(x + 1, y + 1, 0);
			return;
		}

		// 좌하 방향에서 좌측에 부딪힌 경우 ---> 우하
		if (dir == 3 && x == 0) {
			move(x + 1, y - 1, 1);
			return;
		}

		// 우상 방향에서 북쪽에 부딪힌 경우 ---> 우하
		if (dir == 0 && y == h) {
			move(x + 1, y - 1, 1);
			return;
		}

		// 좌상 방향에서 북쪽에 부딪힌 경우 ---> 좌하
		if (dir == 2 && y == h) {
			move(x - 1, y - 1, 3);
			return;
		}

		// 우하 방향에서 우측에 부딪힌 경우 ---> 우상
		if (dir == 1 && y == 0) {
			move(x + 1, y + 1, 0);
			return;
		}

		// 좌하 방향에서 우측에 부딪힌 경우 ---> 좌상
		if (dir == 3 && y == 0) {
			move(x - 1, y + 1, 2);
			return;
		}
		
		int move = 0;
		// 부딪히는 공간이 아닌경우
		if(dir == 0) { // 우상
			move = Math.min(t, Math.min(w-x, h-y));
		} else if(dir == 1) { // 우하
			move = Math.min(t, Math.min(w-x, y));
		} else if(dir == 2) { // 좌상
			move = Math.min(t, Math.min(x, h-y));
		} else { // 좌하
			move = Math.min(t, Math.min(x, y));
		}
		
		t -= (move-1);
		move(x+d[dir][0]*move, y+d[dir][1]*move, dir);
		return;
	}

}
