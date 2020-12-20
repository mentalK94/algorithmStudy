/**
 * Backjoon - 4458. 첫 글자를 대문자로
 * 첫글자를대문자로_4458.java
 * @date 2020-12-20
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 첫글자를대문자로_4458 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.charAt(0)>=97 && str.charAt(0)<=122)
				sb.append((char)(str.charAt(0)-32));
			else sb.append(str.charAt(0));
			for(int j=1; j<str.length(); j++) {
				sb.append(str.charAt(j));
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}