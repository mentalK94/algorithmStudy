/**
 * Backjoon - 5622. 다이얼
 * Dial_5622.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dial_5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int time = 0;
		
		for(int i=0; i<str.length(); i++) {
			int base = 3;
			if(str.charAt(i)-'A' <= ('O'-'A')) {
				time += base + (str.charAt(i)-'A')/3;
			} else if(str.charAt(i)-'A' <= ('S'-'A') && str.charAt(i)-'A' >= ('P'-'A')) {
				time += 8;
			} else if(str.charAt(i)-'A' <= ('V'-'A') && str.charAt(i)-'A' >= ('T'-'A')) {
				time += 9;
			} else if(str.charAt(i)-'A' <= ('Z'-'A') && str.charAt(i)-'A' >= ('W'-'A')) {
				time += 10;
			}
		}
		
		System.out.println(time);
	}

}
