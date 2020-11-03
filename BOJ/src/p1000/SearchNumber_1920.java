/**
 * Backjoon - 1920. 수 찾기
 * SearchNumber_1920.java
 * @date 2020-11-03
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SearchNumber_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<Integer> numSet = new HashSet<>();
		for(int i=0; i<N; i++) {
			numSet.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<M; j++) {
			int num = Integer.parseInt(st.nextToken());
			if(numSet.contains(num)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
