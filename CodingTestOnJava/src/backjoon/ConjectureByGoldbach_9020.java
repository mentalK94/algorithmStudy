/**
 * Backjoon - 9020. 골드바흐의 추측
 * ConjectureByGoldbach_9020.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConjectureByGoldbach_9020 {
	
	private static boolean[] isNotPrime;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		isNotPrime = new boolean[10001];
		isNotPrime[1] = true; // 소수가 아님을 표기 		
		
		for(int i=2; (i*i)<isNotPrime.length; i++) {
			for(int j=(i*i); j<isNotPrime.length; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int x = n/2;
			int y = n-x;
			
			if((!isNotPrime[x]) && (!isNotPrime[y])) {
				sb.append(x).append(" ").append(y).append("\n");
				continue;
			}
			
			while(x>=2) {
				--x;
				++y;
				
				if((!isNotPrime[x]) && (!isNotPrime[y])) {
					sb.append(x).append(" ").append(y).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}
