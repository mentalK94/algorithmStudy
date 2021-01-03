/**
 * Backjoon - 1654. 랜선 자르기
 * 랜선자르기_1654.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken());
		
		int[] lanLines = new int[K];
		
		for(int i=0; i<K; i++) {
			lanLines[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lanLines);
		
		long min = 1;
		long max = lanLines[K-1];
		long mid = 0;
		
		while(min<=max) {
			mid = (min+max)/2;
			
			int cnt = 0;
			for(int i=0; i<K; i++) {
				cnt += (lanLines[i]/mid);
			}
			
			if(cnt>=N) {
				min = mid+1;
			} else {
				max = mid-1;
			}			
		}
		
		System.out.println(max);
		br.close();
	}
}