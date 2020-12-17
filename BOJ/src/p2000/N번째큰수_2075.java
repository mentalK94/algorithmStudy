/**
 * Backjoon - 2075. N번째 큰 수
 * N번째큰수_2075.java
 * @date 2020-12-17
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N번째큰수_2075 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N*N];
		int idx = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				data[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(data);
		System.out.println(data[data.length-N]);
		
		br.close();
	}

}
