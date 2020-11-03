/**
 * Backjoon - 2581. 소수
 * PrimeNumber_2581.java
 * @date 2020-08-21
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber_2581 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isNotPrime = new boolean[10001];
		isNotPrime[1] = true; // 소수가 아님을 표기 		
		
		for(int i=2; (i*i)<isNotPrime.length; i++) {
			for(int j=(i*i); j<isNotPrime.length; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = 0;
		int sum = 0;
		
		for(int i=M; i<=N; i++) {
			if(!isNotPrime[i]) {
				if(min == 0) {min=i;}
				sum+=i;
			}
		}
		
		if(min == 0)
			System.out.println(-1);
		else 
			System.out.println(sum + "\n" + min);
	}

}
