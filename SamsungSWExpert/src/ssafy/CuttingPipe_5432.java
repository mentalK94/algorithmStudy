/**
 * swexpert - 5432. 쇠막대기 자르기
 * CuttingPipe_5432.java
 * @date 2020-08-31
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuttingPipe_5432 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int count = 0;
			int pipe = 0;

			String batch = br.readLine();

			for (int i = 0; i < batch.length(); i++) {

				if (batch.charAt(i) == '(') { // 1. '('인 경우 바로 뒤에 것 확인

					if (batch.charAt(i + 1) == ')') { // 1-1. ')'인 경우 레이저 ---> 쇠막대기마다 레이저 추가
						count += pipe;
						i++;
					} else { // 1-2. '('인 경우 쇠막대기 ---> 쇠막대기 추가
						pipe++;
					}
				} else { // 2. ')'인 경우
					pipe--;
					count++;
				}

			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

}
