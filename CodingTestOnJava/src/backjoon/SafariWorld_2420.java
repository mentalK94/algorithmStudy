/**
 * Backjoon - 2420. 사파리 월드
 * SafariWorld_2420.java
 * @date 2020-09-28
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafariWorld_2420 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		System.out.println(Math.abs(N-M));
	}

}
