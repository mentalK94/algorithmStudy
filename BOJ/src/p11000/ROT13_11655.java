/**
 * Backjoon - 11655. ROT13
 * ROT13_11655.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ROT13_11655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch>=65 && ch<=90) {
				ch-=(65-13);
				ch%=26;
				sb.append((char)(ch+65));
				continue;
			}
			
			if(ch>=97 && ch<=122) {
				ch-=(97-13);
				ch%=26;
				sb.append((char)(ch+97));
				continue;
			}
			
			sb.append(ch);
		}
		
		System.out.println(sb);
		br.close();

	}

}
