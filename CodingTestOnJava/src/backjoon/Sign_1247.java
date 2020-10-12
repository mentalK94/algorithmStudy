/**
 * Backjoon - 1247. 부호
 * Sign_1247.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sign_1247 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		BigInteger zero = new BigInteger("0");
		for(int t=0; t<3; t++) {
			int n = Integer.parseInt(br.readLine());
			BigInteger bigInteger = new BigInteger("0");
			for(int i=0; i<n; i++) {
				String a = br.readLine();
				BigInteger temp = new BigInteger(a);
				bigInteger = bigInteger.add(temp);
			}
						
			if(bigInteger.compareTo(zero) > 0) {
				sb.append("+").append("\n");
			} else if(bigInteger.compareTo(zero) < 0) {
				sb.append("-").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb);
	}

}
