/**
 * Backjoon - 1225. 이상한 곱셈
 * AnomalyMultiple_1225.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AnomalyMultiple_1225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		long answer = 0;
		
		for(int i=0; i<a.length(); i++) {
			int aNum = a.charAt(i) - '0';
			for(int j=0; j<b.length(); j++) {
				int bNum = b.charAt(j) - '0';
				
				answer += (aNum * bNum);
			}
		}
		
		System.out.println(answer);
	}

}
