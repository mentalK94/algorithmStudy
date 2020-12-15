/**
 * Backjoon - 2857. FBI
 * FBI_2857.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FBI_2857 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=5; i++) {
			String input = br.readLine();
			if(input.contains("FBI")) {
				sb.append(i).append(" ");
			}
		}
		
		if(sb.length() == 0) {sb.append("HE GOT AWAY!"); }
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
