/**
 * Samsung SW Expert - 2117. 홈 방범 서비스
 * HomePreventionService_2117.java
 * @date 2020-09-10
 * @author hansolKim
 * */


package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HomePreventionService_2117 {

	private static int N, M, K, income; // 도시의 크기, 집에서 지불하는 비용
	private static int[][] map;
	private static StringBuilder sb;
	private static ArrayList<int[]> homeList;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			homeList = new ArrayList<>();
			map = new int[N][N];
			int answer = 0;
			int homeCnt = 0;
			K = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int state = Integer.parseInt(st.nextToken());
					 if (state == 1) { // 집의 위치 추가
						 // homeList.add(new int[] { i, j });
						 homeCnt++;
					 }
					map[i][j] = state;
				}
			}

			while (homeCnt * M > getCost(K)) { // 집의 총 갯수 * 지불 비용 = 벌 수 있는 총 금액이 운영 비용보다 작을 때까지 K값을 늘림
				K++;
			}
			K--;
			for (int k = K; k >= 0; k--) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						income = 0;
						System.out.println(i + ", " + j +", " + k);
						if (isProfit(i, j, k)) { // 수익이 되는지 여부 검사 --> 수익이 발생하지 못하면
							answer = Math.max(answer, income / M);
						}
					}
				}
				if(answer != 0) { break; }
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}

	/* 파라미터 좌표값을 기준으로 k값을 통해 이득을 볼 수 있는 지 여부 조사 */
	private static boolean isProfit(int x, int y, int k) {

		int limit = 0;
		// 1. 윗부분 탐색
		for (int i = x - k + 1; i <= x - 1; i++) {
			// 1-1. 현재위치
			if (isArea(i, y) && map[i][y] == 1) {
				income += M;
			}

			int temp = 1;
			// 1-2. 왼쪽탐색
			while (temp <= limit) {
				if (isArea(i, y - temp) && map[i][y - temp] == 1) {
					income += M;
				}
				temp++;
			}

			// 1-3. 오른쪽탐색
			temp = 1;
			while (temp <= limit) {
				if (isArea(i, y + temp) && map[i][y + temp] == 1) {
					income += M;
				}
				temp++;
			}
			limit++;
		}

		// 2. 가운데 부분 탐색
		for (int i = y - k + 1; i <= y + k - 1; i++) {
			if (isArea(x, i) && map[x][i] == 1) {
				income += M;
			}
		}

		// 3. 아랫쪽 부분 탐색
		for (int i = x + 1; i <= x + k - 1; i++) {
			// 1-1. 현재위치
			if (isArea(i, y) && map[i][y] == 1) {
				income += M;
			}

			// 1-2. 왼쪽탐색
			int temp = 1;
			while (temp <= limit) {
				if (isArea(i, y - temp) && map[i][y - temp] == 1) {
					income += M;
				}
				temp++;
			}

			// 1-3. 오른쪽탐색
			temp = 1;
			while (temp <= limit) {
				if (isArea(i, y + temp) && map[i][y + temp] == 1) {
					income += M;
				}
				temp++;
			}
			limit--;
		}

		System.out.println(income +" ### "+getCost(k));
		if (income >= getCost(k)) {
			return true;
		}

		return false;

	}

	private static int getCost(int k) {
		return k * k + (k - 1) * (k - 1);
	}

	private static boolean isArea(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
