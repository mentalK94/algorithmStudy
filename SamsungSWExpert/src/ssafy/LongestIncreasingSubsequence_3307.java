/**
 * Samsung SW Expert - 3307. 최장 증가 부분 수열
 * LongestIncreasingSubsequence_3307.java
 * @date 2020-09-24
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence_3307 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] dp = new int[n];
			int max = 0;
			dp[0] = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i < n; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
 
			}
			
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
