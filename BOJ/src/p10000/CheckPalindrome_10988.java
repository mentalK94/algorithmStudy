/**
 * Backjoon - 10988. 팰린드롬인지 확인하기
 * CheckPalindrome_10988.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckPalindrome_10988 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int mid = str.length()/2;
		
		int left = mid-1;
		int right = str.length()%2==0 ? mid : mid+1;
		
		boolean isPalindrome = true;
		while(left>=0 && right<str.length()) {
			if(str.charAt(left) != str.charAt(right)) {
				isPalindrome = false;
				break;
			}
			left--;
			right++;
		}
		
		if(isPalindrome) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		br.close();

	}

}
