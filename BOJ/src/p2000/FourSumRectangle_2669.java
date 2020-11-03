/**
 * Backjoon - 2669. 직사각형 네개의 합집합의 면적 구하기
 * FourSumRectangle_2669.java
 * @date 2020-09-22
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourSumRectangle_2669 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] xy = new int[4][4];
		boolean[][] area = new boolean[101][101];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				xy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int k = xy[i][0]; k < xy[i][2]; k++) {
				for (int t = xy[i][1]; t < xy[i][3]; t++) {
					area[k][t] = true;
				}
			}
		}

		int answer = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (area[i][j]) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

}
