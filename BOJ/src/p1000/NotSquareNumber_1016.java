/**
 * Backjoon - 1016. 제곱 ㄴㄴ수
 * NotSquareNumber_1016.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotSquareNumber_1016 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		int gap = (int) (max - min);
		boolean[] arr = new boolean[gap + 1];

		int cnt = 0;
		for (long i = min; i <= max; i++) {
			if (arr[(int) (i - min)])
				continue;
			long sqrt = (long) Math.floor(Math.sqrt((double) i));
			if (sqrt == 1 || (i != sqrt*sqrt && i != (sqrt + 1)*(sqrt + 1))) {
				cnt++;
			}
			if (i > 1) {
				for (long j = i*i; j <= max; j *= i) {
					arr[(int) (j - min)] = true;
				}
			}
		}
		System.out.println(cnt);
	}

}
