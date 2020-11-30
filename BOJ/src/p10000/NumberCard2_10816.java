/**
 * Backjoon - 10816. 숫자 카드 2
 * NumberCard2_10816.java
 * @date 2020-11-30
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard2_10816 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			int value = 1;
			if(map.containsKey(key)) {
				value = map.get(key) + 1;
			}
				
			map.put(key, value);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			int value = 0;
			if(map.containsKey(key)) {
				value = map.get(key);
			}
			
			sb.append(value).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}

}
