/**
 * Backjoon - 1264. 모음의 개수
 * NumberOfVowel_1264.java
 * @date 2020-10-13
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfVowel_1264 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("#")) {break;}
			
			int answer = 0;
			str = str.toLowerCase();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) =='a' || str.charAt(i) =='e' || str.charAt(i) =='i' || str.charAt(i) =='o' || str.charAt(i) =='u') {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
