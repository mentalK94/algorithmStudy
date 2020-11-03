/**
 * Backjoon - 14888. 연산자 끼워넣기
 * InsertOperator_14888.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package p14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InsertOperator_14888 {

	static int N, min, max;
	static int[] numbers;
	static int[] operators, selected;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operators = new int[N - 1];
		selected = new int[N - 1];
		visited = new boolean[N - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int opIdx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				operators[opIdx++] = i;
			}
		}

		permutation(0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int cnt) {
		if (cnt == N - 1) {

			int numIdx = 0;
			int num = numbers[numIdx++];

			for (int i = 0; i < N - 1; i++) {
				switch (selected[i]) {
				case 0: // '+'
					num += numbers[numIdx++];
					break;
				case 1: // '-'
					num -= numbers[numIdx++];
					break;
				case 2: // '*'
					num *= numbers[numIdx++];
					break;
				case 3: // '/'
					if(num<0) {
						num = Math.abs(num);
						num /= numbers[numIdx++];
						num *= (-1);
					} else {
						num /= numbers[numIdx++];
					}
					break;
				}
			}
			
			if(num<min) { min = num; }
			if(num>max) { max = num; }
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (visited[i])
				continue;

			selected[cnt] = operators[i];
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}

}
