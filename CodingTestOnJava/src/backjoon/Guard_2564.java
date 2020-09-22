/**
 * Backjoon - 2564. 경비원
 * Guard_2564.java
 * @date 2020-09-22
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Guard_2564 {

	private static int w, h, n; // 너비, 높이, 상점의 개수
	private static int guardX, guardY; // 경비원의 위치
	private static ArrayList<int[]> list; // 상점의 좌표 리스트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 너비와 높이 크기 입력
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		// 상점의 개수 입력
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		// 각 상점의 방향과 떨어진 거리 입력
		for (int i = 0; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int r = Integer.parseInt(st.nextToken()); // 떨어진 거리

			if (dir == 1) {
				list.add(new int[] { 0, r });
			} // 북쪽
			if (dir == 2) {
				list.add(new int[] { h, r });
			} // 남쪽
			if (dir == 3) {
				list.add(new int[] { r, 0 });
			} // 서쪽
			if (dir == 4) {
				list.add(new int[] { r, w });
			} // 동쪽
		}
		
		// 경비원의 위치 입력
		guardX = list.get(list.size()-1)[0];
		guardY = list.get(list.size()-1)[1];

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer += getDist(list.get(i)[0], list.get(i)[1], guardX, guardY);
		}

		System.out.println(answer);
		br.close();
	}

	/** 두 점사이의 거리 계산 구현 */
	private static int getDist(int shopX, int shopY, int gX, int gY) {
		// 1. 마주보는 위치에 있는 경우
		// 1-1. 남과 북에 있는 경우
		if (Math.abs(shopX - gX) == h) {
			// 경비원의 위치를 양쪽 끝에 다 두고 거리 계산 후 짧은 것으로 리턴
			return Math.min(gY + getDist2(shopX, shopY, gX, 0), w-gY + getDist2(shopX, shopY, gX, w));
		}
		// 1-2. 동과 서쪽에 있는 경우
		if (Math.abs(shopY - gY) == w) {
			// 경비원의 위치를 맨 위쪽과 아랫쪽으로 위치 시킨 다음 거리 계산 후 짧은 것으로 리턴
			return Math.min(gX + getDist2(shopX, shopY, 0, gY), h-gY + getDist2(shopX, shopY, h, gY));
		}
		// 2. 마주보는 위치에 있지 않은 경우
		return getDist2(shopX, shopY, gX, gY);
	}

	private static int getDist2(int startX, int startY, int targetX, int targetY) {
		return Math.abs(startX - targetX) + Math.abs(startY - targetY);
	}

}
