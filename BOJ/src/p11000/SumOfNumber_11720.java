/**
 * Backjoon - 11720. 숫자의 합
 * SumOfNumber_11720.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p11000;

import java.util.Scanner;

public class SumOfNumber_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		String str1 = sc.nextLine();
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			sum += str.charAt(i)-'0';
		}
		
		System.out.print(sum);
	}

}
