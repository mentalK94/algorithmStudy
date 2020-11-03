/**
 * Backjoon - 3046. R2
 * R2_3046.java
 * @date 2020-10-07
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidNumber_2475 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = 0;
		for(int i=0; i<5; i++)
			n += Math.pow(Integer.parseInt(st.nextToken()), 2);
		System.out.println(n%10);
	}

}
