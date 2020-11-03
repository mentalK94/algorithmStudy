/**
 * Backjoon - 10870. 피보나치 수 5
 * Fibonacci_10870.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package p10000;

import java.util.Scanner;

public class Fibonacci_10870 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
	}

	private static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
