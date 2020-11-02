/**
 * Samsung SW Expert - 1952. 수영장
 * SwimmingPool_1952.java
 * @date 2020-10-31
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwimmingPool_1952 {

	static int[] moneys, days;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			
			moneys = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				moneys[i] = Integer.parseInt(st.nextToken());
			}
			
			days = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc).append(" ").append(plan2()).append("\n");
		}
		System.out.println(sb);
	}
	
	/*static void plan() {
		min = moneys[3]; // 1년 사용권 금액을 기본 최소값
		calc(0, 0);
	}
	
	// 매달의 이용가능한 경우를 고려하여 계산
	static void calc(int m, int sum) {
		
		if(m>=12) {
			if(sum < min) { min = sum;}
			return;
		}
		
		// 1일권 사용 경우 : 사용 일수 * 1일권 금액
		calc(m+1, sum+days[m]*moneys[0]);
		
		// 1달권 사용 경우
		calc(m+1, sum+(days[m]>0?moneys[1]:0));
		
		// 3달권 사용 경우
		if(days[m]>0) {
			calc(m+3, sum+moneys[2]);
		} else {
			calc(m+1, sum);
		}
	}*/

	static int plan2() {
		int dp[] = new int[13];
		for(int i=1; i<=12; i++) {
			// 1일권
			dp[i] = dp[i-1] + days[i]*moneys[0];
			// 1달권
			if(days[i]>0) dp[i] = Math.min(dp[i], dp[i-1] + moneys[1]);
			// 3달권
			if(i>=3) dp[i] = Math.min(dp[i], dp[i-3] + moneys[2]);
		}
		return Math.min(dp[12], moneys[3]); // 12월까지의 최소비용과 1년권을 비교
	}
}
