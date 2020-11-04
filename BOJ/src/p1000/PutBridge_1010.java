/**
 * Backjoon - 1010. 다리 놓기
 * PutBridge_1010.java
 * @date 2020-11-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PutBridge_1010 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			N = N < M-N ? N : M-N;
			
			long answer = 1;
			int curN = N;
			for(int i=0; i<N; i++) {
				int cur = M-i;
				
				answer*=cur;
				
				if(curN>1 && cur%curN==0) {
					answer /= curN;
					curN--;
				}
			}
			
			for(int i=curN; i>=1; i--) {
				answer/=i;
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
