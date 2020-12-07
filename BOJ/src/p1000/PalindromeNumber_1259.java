/**
 * Backjoon - 1259. 팰린드롬수
 * PalindromeNumber_1259.java
 * @date 2020-12-07
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromeNumber_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String num = br.readLine();
			if(num.equals("0")) {break;}
			
			int mid = num.length()/2;
			int left = mid-1;
			int right = (num.length()%2==0) ? mid : mid+1;
			
			boolean isPalindrome = true;
			while(left>=0 && right<num.length()) {
				if(num.charAt(left) != num.charAt(right)) {
					isPalindrome = false;
					break;
				}
				left--;
				right++;
			}
			
			if(isPalindrome) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
