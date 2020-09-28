/**
 * Backjoon - 1003. 피보나치 함수
 * FibonacciFunc_1003.java
 * @date 2020-09-29
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FibonacciFunc_1003 {
	
	static int[][] memory;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			int n = Integer.parseInt(br.readLine());
			memory = new int[n + 2][2];
			
			memory[0][0] = 1;
			memory[1][1] = 1;
			for(int i=2; i<=n; i++) {
				memory[i][0] = memory[i-1][1];
				memory[i][1] = memory[i-1][1] + memory[i-2][1];				
			}
			
			for(int i=0; i<=n; i++) {
				System.out.println(memory[i][0] + " " + memory[i][1]);
			}

			sb.append(memory[n][0]).append(" ").append(memory[n][1]).append("\n");
		}

		System.out.println(sb);
	}
}
