/**
 * Backjoon - 2941. 크로아티아 알파벳
 * CroatiaAlphabet_2941.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlphabet_2941 {

	private static int count = 0;
	private static String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if(i == str.length()-1) { 
				count++;
				break;
			}
			
			String temp = str.substring(i, i+2);
			for(int j=0; j<croatian.length; j++) {
				if(croatian[j].contains(temp)) {
					i+=croatian[j].length()-1;
					break;
				}
			}
			
			count++;
		}
		
		System.out.println(count);
	}

}
