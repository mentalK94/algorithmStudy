/**
 * Backjoon - 2747. 피보나치 수
 * Fibonacci_2747.java
 * @date 2020-09-28
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class Fibonacci_2747 {

	static int memory[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		memory = new int[num+1];
		
		int answer = fibo(num);
		
		System.out.println(answer);
	}

	private static int fibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(memory[n] == 0) {
			return memory[n] = fibo(n-1) + fibo(n-2);
		}
		return memory[n];
	}

}
