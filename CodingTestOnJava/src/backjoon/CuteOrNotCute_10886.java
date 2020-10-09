/**
 * Backjoon - 10886. 0 = not cute / 1 = cute
 * CuteOrNotCute_10886.java
 * @date 2020-10-07
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuteOrNotCute_10886 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cute = 0;
		for(int i=0; i<n; i++) {
			cute += Integer.parseInt(br.readLine());
		}
		
		String str = "Junhee is ";
		
		String cuteStr = n-cute > n/2 ? "not cute!" : "cute!";
		System.out.println(str + cuteStr);
	}

}
