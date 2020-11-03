/**
 * Backjoon - 1159. 농구경기
 * BasketballGame_1159.java
 * @date 2020-09-19
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BasketballGame_1159 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[26];
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			cnt[name.charAt(0)-97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<26; i++) {
			if(cnt[i] >= 5) {
				sb.append((char)(i+97));
			}
		}
		
		if(sb.length() == 0)
			System.out.println("PREDAJA");
		else System.out.println(sb);
	}

}
