/**
 * Samsung SW Expert - 3234. 준환이의 양팔저울
 * JunHwansScale_3234.java
 * @date 2020-08-28
 * @author hansolKim
 **/


package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JunHwansScale_3234 {

	private static int N; // 추의 개수
	private static int[] scales, numbers; // 추의 무게 종류
	private static StringBuilder sb;
	private static int count;
	private static boolean[] isSelected;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			// 초기화
			count = 0;

			N = Integer.parseInt(br.readLine()); // 추의 개수 입력

			scales = new int[N];
			numbers = new int[N];
			isSelected = new boolean[N];

			StringTokenizer data = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++)
				scales[i] = Integer.parseInt(data.nextToken());

			permutation(0);

			sb.append(count).append("\n");

		}

		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			int idx = 0;
			int left=0, right=0; // 양쪽 저울 무게 초기화

			// 1. 첫번째 추는 무조건 왼쪽에 올라가게 된다
			left += numbers[idx++];

			// 2. 2번째 부터 N번째 까지 왼쪽에 놓는 경우와 오른쪽에 놓는 경우
			put(left, right, idx);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			numbers[cnt] = scales[i];
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void put(int left, int right, int idx) {

		if (left < right) {
			return;
		} // 오른쪽 무게가 왼쪽보다 커지는 경우

		if (idx == N) {
			count++;
			return;
		}

		// 오른쪽으로 두는 경우
		put(left, right + numbers[idx], idx + 1);
		// 왼쪽으로 두는 경우
		put(left + numbers[idx], right, idx + 1);
	}

}
