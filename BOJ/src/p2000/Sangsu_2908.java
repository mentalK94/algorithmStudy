/**
 * Backjoon - 2908. 상수
 * Sangsu_2908.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sangsu_2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String strA = st.nextToken();
		String strB = st.nextToken();
		
		for(int i=strA.length()-1; i>=0; i--) {
			if(strA.charAt(i) > strB.charAt(i)) { // strA가 더 큰 경우
				sb.append(strA);
				break;
			} else if(strA.charAt(i) < strB.charAt(i)) { // strB가 더 큰 경우
				sb.append(strB);
				break;
			} 
		}
		
		System.out.println(sb.reverse().toString());
	}

}
