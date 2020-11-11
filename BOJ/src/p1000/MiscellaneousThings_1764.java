/**
 * Backjoon - 1764. 듣보잡
 * MiscellaneousThings_1764.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MiscellaneousThings_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>(); 
		
		for(int i=0; i<n; i++) {
			String name = br.readLine();
			map.put(name, 0);
 		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();
		int cnt = 0;
		for(int i=0; i<m; i++) {
			String name2 = br.readLine();
			if(map.containsKey(name2)) {
				cnt++;
				list.add(name2);
			}
		}
		
		Collections.sort(list);
		
		sb.append(cnt).append("\n");
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}

}
