/**
 * Backjoon - 1009. 분산처리
 * DistributedProcessing_1009.java
 * @date 2020-09-13
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DistributedProcessing_1009 {

	public static void main(String[] args) throws Exception {
		
		int[][] memory = {{10}, {1}, {6,2,4,8}, {1,3,9,7}, {6,4},
						  {5}, {6}, {1,7,9,3}, {6,8,4,2}, {1,9}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a>=10) {
				a %= 10;
			}
			
			sb.append(memory[a][(b%memory[a].length)]).append("\n");
		}
		System.out.println(sb);		
	}

}
