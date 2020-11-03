/**
 * Backjoon - 1316. 그룹 단어 체커
 * GroupWordChecker_1316.java
 * @date 2020-08-19
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWordChecker_1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		boolean[] alphabet;
		boolean isCheck;
 		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			alphabet = new boolean[26];
			isCheck = true; // 그룹 단어인 경우 
			
			for(int j=0; j<str.length(); j++) {
				int num = str.charAt(j)-97;
				if(alphabet[num]) { // 떨어진 경우
					isCheck = false;
					break;
				} 
				
				/* 처음 들어온 경우 */
				while(j<str.length()-1) {
					int num2 = str.charAt(j+1)-97;
					if(num != num2) { break;}
					j++;
				}
				
				alphabet[num] = true;
			}
			
			if(isCheck) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}

}
