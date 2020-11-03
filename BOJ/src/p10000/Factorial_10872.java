/**
 * Backjoon - 10872. 팩토리얼
 * Factorial_10872.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_10872 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(n));
	}

	private static int factorial(int n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		return n * factorial(n-1);
	}

}
