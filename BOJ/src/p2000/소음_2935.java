/**
 * Backjoon - 2935. 소음
 * 소음_2935.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 소음_2935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String op = br.readLine();
		String b = br.readLine();
		
		StringBuilder sb = new StringBuilder();

		int longLength = a.length() > b.length() ? a.length() : b.length();
		int shortLength = a.length() > b.length() ? b.length() : a.length();
		
		if(op.equals("*")) {
			sb.append("1");
			for(int i=0; i<longLength+shortLength-2; i++) {
				sb.append("0");
			}
		} else {
			if(longLength != shortLength) {
				sb.append("1");
				int idx = longLength-shortLength;
				for(int i=1; i<longLength; i++) {
					if(i == idx) { sb.append("1"); continue;}
					sb.append("0");
				}
			} else {
				sb.append("2");
				for(int i=0; i<longLength-1; i++) {
					sb.append("0");
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}