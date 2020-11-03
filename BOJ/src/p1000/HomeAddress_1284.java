/**
 * Backjoon - 1284. 집 주소
 * HomeAddress_1284.java
 * @date 2020-10-26
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeAddress_1284 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {			
			String N = br.readLine();
			if(N.equals("0")) { break;}
			
			int answer = 2;
			answer += (N.length()-1);
			for(int i=0; i<N.length(); i++) {
				if(N.charAt(i) == '0') { answer+=4;}
				else if(N.charAt(i) == '1') { answer+=2;}
				else {answer+=3;}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
