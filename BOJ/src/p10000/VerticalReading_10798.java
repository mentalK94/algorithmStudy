/**
 * Backjoon - 10798. 세로 읽기
 * VerticalReading_10798.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VerticalReading_10798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String[] strs = new String[5];
		
		int length = 0;
		for(int i=0; i<5; i++) {
			strs[i] = br.readLine();
			if(length < strs[i].length()) {
				length = strs[i].length();
			}
		}
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<5; j++) {
				if(strs[j].length() <= i) continue;
				sb.append(strs[j].charAt(i));
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
