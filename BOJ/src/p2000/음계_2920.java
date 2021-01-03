/**
 * Backjoon - 2920. 음계
 * 음계_2920.java
 * @date 2021-01-03
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		
		int type = start == 1 ? 1 : 2; // 1이면 ascending 2이면 descending
		
		for(int i=1; i<8; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			start = type==1 ? start+1 : start-1;
			if(start != next) { type = 3; break; } 
		}
		
		String answer = type == 1 ? "ascending" : type == 2 ? "descending" : "mixed";
		System.out.println(answer);
		br.close();
	}
}