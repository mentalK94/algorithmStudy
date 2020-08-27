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

	private static char[][] map;
	private static int[] dx = { -1, 0, 1 };
	private static int R, C; // R : 행 수, C : 열 수
	private static int answer = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer init = new StringTokenizer(br.readLine());

		R = Integer.parseInt(init.nextToken());
		C = Integer.parseInt(init.nextToken());

		map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			setPipeline(i, 0);
		}

		System.out.println(answer);
	}

	private static boolean setPipeline(int x, int y) {

		// 1. 유도조건 ---> 맨 오른쪽인 식당에 도착한 경우
		if (y == C - 1) {
			answer++;
			return true;
		}

		// 2. 기저조건
		for (int i = 0; i < 3; i++) {
			int rx = x + dx[i];

			if (rx < 0 || rx >= R || map[rx][y+1] != '.') continue; 

			map[rx][y+1] = '#'; // 파이프 놓기
			if(setPipeline(rx, y+1)) return true;  // 다음 칸으로 이동 후 진행 결과과 끝까지 연결이 가능했다면 현위치에서 다른 방향으로 파이프 놓기 시도를 중단하고 이전 위치로 돌아감
			
		}
		
		return false;
	}

}
