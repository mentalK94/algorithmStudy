/**
 * Backjoon - 4999. 아!
 * Ah_4999.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ah_4999 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String doctor = br.readLine();
		
		if(input.length()>=doctor.length()) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
}
