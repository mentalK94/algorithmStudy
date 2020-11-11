/**
 * Backjoon - 2902. KMP는 왜 KMP일까
 * WhyKMP_2902.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhyKMP_2902 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int cnt = st.countTokens();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cnt; i++) {
			sb.append(st.nextToken().charAt(0));
		}
		System.out.println(sb);
	}

}
