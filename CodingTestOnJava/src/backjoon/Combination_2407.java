/**
 * Backjoon - 2407. 조합
 * Combination_2407.java
 * @date 2020-09-02
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination_2407 {

	private static int N, M;
	private static BigInteger denominator, numerator, answer; // 분모, 분자

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		denominator = new BigInteger("1");
		numerator = new BigInteger("1");
		
		if (N - M < 50) {
			M = N - M;
		}
		
		for(int i=0; i<M; i++) {
			denominator = denominator.multiply(new BigInteger(String.valueOf(N-i)));
			numerator = numerator.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		answer = denominator.divide(numerator);

		System.out.println(answer);
	}

	
}
