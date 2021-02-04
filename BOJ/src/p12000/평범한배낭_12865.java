/**
 * Backjoon - 12865. 평범한 배낭
 * 평범한배낭_12865.java
 * @date 2021-01-27
 * @author hansolKim
 **/

package p12000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=K; j++) {
				// [i][j-물건의 무게] + 물건가치와 [i+1][j]와 비교
				if(j>=w) {
					dp[i+1][j] = (dp[i][j-w] + v) > (dp[i][j]) ?
							(dp[i][j-w] + v) : (dp[i][j]);
				} else {
					dp[i+1][j] = dp[i][j];
				}				 
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}
}