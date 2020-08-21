/**
 * Backjoon - 1978. 소수 찾기
 * FindPrimeNumber_1978.java
 * @date 2020-08-21
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimeNumber_1978 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isNotPrime = new boolean[1001];
		isNotPrime[1] = true; // 소수가 아님을 표기 		
		
		for(int i=2; (i*i)<isNotPrime.length; i++) {
			for(int j=(i*i); j<isNotPrime.length; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(!isNotPrime[n]) answer++;
		}
		
		System.out.println(answer);
	}

}
