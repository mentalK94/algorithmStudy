/**
 * Backjoon - 2869. 달팽이는 올라가고 싶다
 * SnailWantGoUp_2869.java
 * @date 2020-08-19
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class SnailWantGoUp_2869 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int day = 0;
		
		day = (int)Math.ceil(((double)(V-A)/(double)(A-B)))+ 1;
		
		System.out.println(day);
	}
}
