/**
 * Backjoon - 9093. 단어 뒤집기
 * ReverseWord_9093.java
 * @date 2020-11-12
 * @author hansolKim
 **/

package p9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseWord_9093 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
				
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = st.countTokens();
			
			for(int j=0; j<cnt; j++) {
				String word = st.nextToken();
				for(int k=word.length(); k>0; k--) {
					sb.append(word.charAt(k-1));
				}
				sb.append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
