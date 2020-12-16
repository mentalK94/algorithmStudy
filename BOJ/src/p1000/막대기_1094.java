/**
 * Backjoon - 1094. 막대기
 * 막대기_1094.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 막대기_1094 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		String data = String.valueOf(Integer.toBinaryString(x));
		
		int cnt = 0;
		for(int i=0; i<data.length(); i++) {
			if(data.charAt(i) == '1') { cnt++; }
		}
		System.out.println(cnt);
		br.close();
	}
}