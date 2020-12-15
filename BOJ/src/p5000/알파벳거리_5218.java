/**
 * Backjoon - 5218. 알파벳 거리
 * 알파벳거리_5218.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳거리_5218 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			String y = st.nextToken();
			
			int size = x.length();
			
			sb.append("Distances: ");
			for(int i=0; i<size; i++) {
				char ch1 = x.charAt(i);
				char ch2 = y.charAt(i);
				
				int dist = 0;
				if(ch1 <= ch2) {
					dist = ch2-ch1;
				} else {
					dist = 26-Math.abs(ch2-ch1);
				}
				sb.append(dist).append(" ");
			}
			sb.append("\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}