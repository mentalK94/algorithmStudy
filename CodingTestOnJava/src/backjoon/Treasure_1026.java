/**
 * Backjoon - 1026. 보물
 * Treasure_1026.java
 * @date 2020-10-26
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure_1026 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer[] a = new Integer[N];
		Integer[] b = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer += (a[i]*b[i]);
		}
		System.out.println(answer);
	}

}
