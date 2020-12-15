/**
 * Backjoon - 1919. 애너그램 만들기
 * 애너그램만들기_1919.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 애너그램만들기_1919 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int[] aNum = new int[26];
		int[] bNum = new int[26];
		for(int i=0; i<a.length(); i++) {
			aNum[a.charAt(i)-97]++;
		}
		
		for(int i=0; i<b.length(); i++) {
			bNum[b.charAt(i)-97]++;
		}
		
		int answer = 0;
		for(int i=0; i<26; i++) {
			answer += Math.abs(aNum[i]-bNum[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}