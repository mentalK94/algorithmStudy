/**
 * Backjoon - 9461. 파도반 수열
 * WavebandSequence_9461.java
 * @date 2020-09-29
 * @author hansolKim
 **/

package p9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WavebandSequence_9461 {

	static long[] memory;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			memory = new long[n+1];
			long answer = getWaveNumber(n);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long getWaveNumber(int n) {
		if(n<=3) return 1;
		if(n<=5) return 2;
		if(memory[n] == 0) {
			memory[n] = getWaveNumber(n-1) + getWaveNumber(n-5);
		}
		return memory[n];
	}
}
