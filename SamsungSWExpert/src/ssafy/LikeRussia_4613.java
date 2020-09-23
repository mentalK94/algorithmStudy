/**
 * Samsung SW Expert - 4613. 러시아 국기같은 깃발
 * LikeRussia_4613.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LikeRussia_4613 {

	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][3]; // 0:white, 1:blue, 2:red

			for (int i = 0; i < N; i++) {
				String data = br.readLine();
				for (int j = 0; j < M; j++) {
					if (data.charAt(j) == 'W') { map[i][0]++; }
					if (data.charAt(j) == 'B') { map[i][1]++; }
					if (data.charAt(j) == 'R') { map[i][2]++; }
				}
			}

			int sum = Integer.MAX_VALUE;
			for (int i = 1; i <= N - 2; i++) {
				for (int j = i + 1; j <= N - 1; j++) {
					int tempSum = 0;

					// 하얀색을 선택한 범위
					for (int k = 0; k < i; k++) {tempSum += (M-map[k][0]);}
					for (int k = i; k < j; k++) {tempSum += (M-map[k][1]);}
					for (int k = j; k < N; k++) {tempSum += (M-map[k][2]);}

					if (tempSum < sum) {
						sum = tempSum;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}
