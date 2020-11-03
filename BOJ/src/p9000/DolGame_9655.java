/**
 * Backjoon - 9655. 돌 게임
 * DolGame_9655.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package p9000;

import java.util.Scanner;

public class DolGame_9655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		N %= 4;
		
		if(N==2) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
