/**
 * Backjoon - 2729. 이진수 덧셈
 * AddBinary_2729.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AddBinary_2729 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();
			
			int size = a.length() > b.length() ? a.length() : b.length();

			int[] numArrayA = new int[size];
			int[] numArrayB = new int[size];
			
			int[] result = new int[size+1];
			
			for(int i=a.length()-1; i>=0; i--) {
				numArrayA[a.length()-i-1] = a.charAt(i)-'0';
			}
			
			for(int i=b.length()-1; i>=0; i--) {
				numArrayB[b.length()-i-1] = b.charAt(i)-'0';
			}
			
			for(int i=0; i<size; i++) {
				result[i] += (numArrayA[i] + numArrayB[i]);
				if(result[i] >= 2) {
					result[i+1] = 1;
					result[i] -= 2;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]);
			}
			
			while(sb.length() > 1) {
				if(sb.charAt(sb.length()-1) == '1') { break; }
				sb.replace(sb.length()-1, sb.length(), "");
			}
			
			answer.append(sb.reverse().toString()).append("\n");
		}
		
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}