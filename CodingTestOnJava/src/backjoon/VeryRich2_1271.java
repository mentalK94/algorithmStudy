/**
 * Backjoon - 1271. 엄청난 부자 2
 * VeryRich2_1271.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class VeryRich2_1271 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger m = new BigInteger(st.nextToken());
		BigInteger n = new BigInteger(st.nextToken());
		
		System.out.println(m.divideAndRemainder(n)[0]);
		System.out.println(m.divideAndRemainder(n)[1]);
	}

}
