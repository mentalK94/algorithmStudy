/**
 * Backjoon - 10797. 10부제
 * TenSystem_10797.java
 * @date 2020-10-07
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TenSystem_10797 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		for(int i=0; i<5; i++) {
			if(Integer.parseInt(st.nextToken())%10 == n) answer++;
		}
		
		System.out.println(answer);
	}

}
