/**
 * Backjoon - 5586. JOI와 IOI
 * JOI와IOI_5586.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p5000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JOI와IOI_5586 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int joi = 0;
		int ioi = 0;
		for(int i=0; i<input.length()-2; i++) {
			if(input.substring(i, i+3).equals("JOI")) {joi++;}
			if(input.substring(i, i+3).equals("IOI")) {ioi++;}
		}
		
		System.out.println(joi);
		System.out.println(ioi);
	}

}
