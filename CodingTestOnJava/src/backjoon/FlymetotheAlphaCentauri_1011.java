/**
 * Backjoon - 1011. Fly me to the Alpha Centauri
 * FlymetotheAlphaCentauri_1011.java
 * @date 2020-08-21
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri_1011 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long answer;
		
		for(int i=0; i<T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			
			long dist = y-x;
			answer = 0;
			
			long n = (long) Math.sqrt(dist);
			answer += 2*(n-1);
			dist -= ((n*n) - n);
			
			answer += Math.ceil((double)dist/(double)n);
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
