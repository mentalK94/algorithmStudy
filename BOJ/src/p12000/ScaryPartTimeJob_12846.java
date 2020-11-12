/**
 * Backjoon - 12846. 무서운 아르바이트
 * ScaryPartTimeJob_12846.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p12000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScaryPartTimeJob_12846 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; n++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int startIdx = 0;
		int endIdx = 0;
		int day = 0; // 연속 일수
		int dayPay = 0; // 가장 낮은 급여
		
		for(int i=0; i<n; n++) {
			
			// 현재 날짜의 급여와 연속된 일수에 따른 급여 비교
			if(dayPay*day <= arr[endIdx]) {
				
			}
		}
	}

}
