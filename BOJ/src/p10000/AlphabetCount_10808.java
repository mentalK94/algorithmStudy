/**
 * Backjoon - 10808. 알파벳 개수
 * AlphabetCount_10808.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlphabetCount_10808 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int[] cnt = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			cnt[word.charAt(i)-97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cnt.length; i++) {
			sb.append(cnt[i]).append(" ");
		}
		System.out.println(sb);
	}

}
