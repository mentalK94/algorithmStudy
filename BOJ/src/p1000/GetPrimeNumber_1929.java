/**
 * Backjoon - 1929. 소수 구하기
 * GetPrimeNumber_1929.java
 * @date 2020-08-21
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetPrimeNumber_1929 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[1] = true; // 소수가 아님을 표기 		
		
		for(int i=2; (i*i)<isNotPrime.length; i++) {
			for(int j=(i*i); j<isNotPrime.length; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			if(!isNotPrime[i]) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
