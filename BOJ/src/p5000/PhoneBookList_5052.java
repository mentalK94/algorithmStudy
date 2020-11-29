/**
 * Backjoon - 5052. 전화번호 목록
 * PhoneBookList_5052.java
 * @date 2020-11-29
 * @author hansolKim
 **/

package p5000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoneBookList_5052 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] phoneList = new String[n];
			
			for(int i=0; i<n; i++) {
				phoneList[i] = br.readLine();
			}
			
			boolean isConsistency = true;
			
			Arrays.sort(phoneList);
			
			for(int i=1; i<phoneList.length; i++) {
				if(phoneList[i].startsWith(phoneList[i-1])) {
					isConsistency = false;
					break;
				}
			}
			
			if(isConsistency) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}

}
