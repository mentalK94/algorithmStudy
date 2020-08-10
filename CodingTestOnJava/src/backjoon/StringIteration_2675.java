/**
 * Backjoon - 2675. 문자열 반복
 * StringIteration_2675.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringIteration_2675 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 0; testcase<T; testcase++) {
						
			StringTokenizer input = new StringTokenizer(br.readLine());
			int iteration = Integer.parseInt(input.nextToken());
			String str = input.nextToken();
			
			for(int i=0; i<str.length(); i++) {
				for(int j=0; j<iteration; j++) {
					sb.append(str.charAt(i));
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
