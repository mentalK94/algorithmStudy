/**
 * Backjoon - 10162. 전자레인지
 * Microwave_10162.java
 * @date 2020-09-16
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Microwave_10162 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int a=0, b=0, c=0;
		
		while(T>=300) {
			T-=300;
			a++;
		}
		
		while(T>=60) {
			T-=60;
			b++;
		}
		
		while(T>=10) {
			T-=10;
			c++;
		}
		if(T == 0)
			System.out.println(a+" "+b+" "+c);
		else
			System.out.println(-1);
	}

}
