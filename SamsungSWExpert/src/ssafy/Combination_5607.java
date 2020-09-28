/**
 * Samsung SW Expert - 5607. 조합
 * Combination_5607.java
 * @date 2020-09-28
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_5607 {

	static final long MOD = 1234567891;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long answer = combination(N, R);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	
	}

	private static long combination(int n, int r) {
		if(r == 0) {
			return 1L;
		}
		
		long[] factorial = new long[n+1];
		factorial[0] = 1;
		
		for(int i=1; i<=n; i++) {
			factorial[i] = factorial[i-1]*i%MOD;
		}
		
		return (factorial[n]*power(factorial[r], MOD-2, MOD) % MOD * power(factorial[n-r], MOD-2, MOD) % MOD) % MOD;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		
		while(y>0) {
			if(y%2==1) {
				res = (res*x)%MOD;
			}
			y = y>>1;
			x = (x*x)%p;
		}
		return res;
	}

}
