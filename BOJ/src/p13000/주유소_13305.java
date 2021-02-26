/**
 * Backjoon - 13305. 주유소
 * 주유소_13305.java
 * @date 2021-02-24
 * @author hansolKim
 **/

package p13000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] dists = new int[N-1];
		int[] values = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			dists[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int selectedValue = Integer.MAX_VALUE;
		long answer = 0L;
		
		for(int i=0; i<N-1; i++) {
			selectedValue = selectedValue < values[i] ? selectedValue : values[i];
			answer += ((long)dists[i]*selectedValue);
		}
		
		System.out.println(answer);
		br.close();
	}

}
