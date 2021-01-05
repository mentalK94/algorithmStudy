/**
 * Backjoon - 13116. 30번
 * 수학30번_13116.java
 * @date 2021-01-05
 * @author hansolKim
 **/

package p13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 수학30번_13116 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		while(T-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			while(a>0) {
				set.add(a);
				a /= 2;
			}
			
			while(!set.contains(b)) {
				b /= 2;
			}
			
			sb.append(b*10).append("\n");
			
			set.clear();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}