/**
 * Backjoon - 1252. 이진수 덧셈
 * AddBinary_1252.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddBinary_1252 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		for(int i=a.length()-1; i>=0; i--) {
			sb.append(a.charAt(i));
		}
		
		a = sb.toString();
		sb.replace(0, sb.length(), "");
		
		for(int i=b.length()-1; i>=0; i--) {
			sb.append(b.charAt(i));
		}
		
		b = sb.toString();
		sb.replace(0, sb.length(), "");

		int size = a.length() < b.length() ? a.length() : b.length();

		boolean flag = false;
		for (int i = 0; i < size; i++) {
			if (a.charAt(i) == '1' && b.charAt(i) == '1') {
				if (flag) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				flag = true;
			} else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
				if (flag) {
					sb.append("0");
					flag = true;
				} else {
					sb.append("1");
				}
			} else {
				if (flag) {
					sb.append("1");
					flag = false;
				} else {
					sb.append("0");
				}
			}
		}

		int idx = size;
		String longNumber = a.length() > b.length() ? a : b;
		while (idx < longNumber.length()) {
			if(flag) {
				if(longNumber.charAt(idx) == '1') {
					sb.append("0");
					flag = true;
				} else {
					sb.append("1");
				}
			} else {
				if(longNumber.charAt(idx) == '1') {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}
			idx++;
		}
		
		if(flag) {sb.append("1");}
		
		boolean zero = true;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) != '0') {
				zero = false;
				break;
			}
		}
		
		if(zero) {
			System.out.println(0);
			return;
		}
		
		System.out.println(sb.reverse().toString());
	}

}
