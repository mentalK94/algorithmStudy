/**
 * Backjoon - 15686. 치킨 배달
 * ChickenDelivery_15686.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AssignSeat_10157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int number = Integer.parseInt(br.readLine());

		if (number > C * R) {
			System.out.println(0);
			return;
		}

		int[][] point = { { 1, 1 }, { 1, R }, { C, R }, { C, 1 } };

		int north = C - 1;
		int south = C - 1;
		int west = R - 1;
		int east = R - 1;
		int answerX, answerY;

		while (true) {
			// 서쪽
			if (number > west) {
				number -= west;
				west -= 2;
				point[0][0]++;
				point[0][1]++;
			} else {
				answerX = point[0][0];
				answerY = point[0][1] + number - 1;
				break;
			}
			// 북쪽
			if (number > north) {
				number -= north;
				north -= 2;
				point[1][0]++;
				point[1][1]--;
			} else {
				answerX = point[1][0] + (number - 1);
				answerY = point[1][1];
				break;
			}
			// 동쪽
			if (number > east) {
				number -= east;
				east -= 2;
				point[2][0]--;
				point[2][1]--;
			} else {
				answerX = point[2][0];
				answerY = point[2][1] - (number - 1);
				break;
			}
			// 남쪽
			if (number > south) {
				number -= south;
				south -= 2;
				point[3][0]--;
				point[3][1]++;
			} else {
				answerX = point[3][0] - (number - 1);
				answerY = point[3][1];
				break;
			}
		}
		
		System.out.println(answerX + " " + answerY);
	}

}
