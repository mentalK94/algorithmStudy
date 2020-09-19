/**
 * Backjoon - 1076. 저항
 * Resistance_1076.java
 * @date 2020-09-19
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Resistance_1076 {

	public static void main(String[] args) throws Exception{
		String[] colors = {"black", "brown", "red", "orange", 
				"yellow", "green", "blue", "violet", 
				"grey", "white"};
		int[] value = {1, 10, 100, 1000, 10000,
				100000, 1000000, 10000000,
				100000000, 1000000000};
		
		long answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		main:for(int i=0; i<3; i++) {
			String color = br.readLine();
			
			if(i == 2) {
				for(int j=0; j<colors.length; j++) {
					if(color.equals(colors[j])) {
						answer*=value[j];
						break main;
					}
				}
			}
			for(int j=0; j<colors.length; j++) {
				if(color.equals(colors[j])) {
					answer *= 10;
					answer += j;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
