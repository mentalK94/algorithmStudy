/**
 * Backjoon - 15829. Hashing
 * Hashing_15829.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hashing_15829 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		long base = 1;
		long answer = 0;
		
		for(int i=0; i<L; i++) {
			answer += ((int)(str.charAt(i)-96) * base);
			base *= 31;
			base %= 1234567891;
			answer %= 1234567891;
		}

		System.out.println(answer);
		br.close();
	}
}