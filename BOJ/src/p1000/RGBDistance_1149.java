/**
 * Backjoon - 1149. RGB거리
 * RGBDistance_1149.java
 * @date 2020-10-26
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBDistance_1149 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] homes = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				homes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dp[0][0] = homes[0][0];
		dp[0][1] = homes[0][1];
		dp[0][2] = homes[0][2];
		
		for(int i=1; i<N; i++) {
			for(int j=0;j<3; j++) {
				for(int k=0; k<3; k++) {
					if(j == k) continue;
					if(homes[i][j] + dp[i-1][k] < dp[i][j]) {
						dp[i][j] = homes[i][j] + dp[i-1][k];
					}
				}
			}
		}
		
		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][0]);
	}

}
