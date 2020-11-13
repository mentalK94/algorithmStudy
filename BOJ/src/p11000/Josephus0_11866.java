/**
 * Backjoon - 11866. 요세푸스0
 * Josephus0_11866.java
 * @date 2020-11-13
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Josephus0_11866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = k-1;
		while(true) {
			
			idx %= list.size();
			sb.append(list.get(idx));
			list.remove(idx);
			
			if(list.size() == 0) {
				break;
			}
			sb.append(", ");
			idx+=(k-1);
		}
		
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}

}
