/**
 * Backjoon - 1120. 문자열
 * String_1120.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_1120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String strA = st.nextToken();
		String strB = st.nextToken();
		
		int gap = strB.length() - strA.length();
		
		int cnt = Integer.MAX_VALUE;
		for(int i=0; i<=gap; i++) {
			int temp = 0;
			for(int j=0; j<strA.length(); j++) {
				if(strA.charAt(j) != strB.charAt(j+i)) { temp++; }
			}
			
			if(temp < cnt) {
				cnt = temp;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}

}