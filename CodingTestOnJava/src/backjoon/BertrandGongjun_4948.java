/**
 * Backjoon - 4948. 베르트랑 공준
 * BertrandGongjun_4948.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BertrandGongjun_4948 {
	
	private static boolean[] isNotPrime;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		isNotPrime = new boolean[246913];
		isNotPrime[1] = true; // 소수가 아님을 표기 		
		
		for(int i=2; (i*i)<isNotPrime.length; i++) {
			for(int j=(i*i); j<isNotPrime.length; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) { break; }
			
			int result = getGongjun(n);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int getGongjun(int n) {
		int count = 0;
		for(int i=n+1; i<=2*n; i++) {
			if(!isNotPrime[i]) {count++;}
		}
		return count;
	}

}
