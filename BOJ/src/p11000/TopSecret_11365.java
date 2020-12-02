/**
 * Backjoon - 11365. !밀비 급일
 * TopSecret_11365.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TopSecret_11365 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("END")) { break; }
			
			for(int i=str.length()-1; i>=0; i--) {
				sb.append(str.charAt(i));
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}