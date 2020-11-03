/**
 * Backjoon - 2523. 별 찍기 - 13
 * PrintStar13_2523.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class PrintStar13_2523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N-1; i++) {
			if(i<N) {
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for(int j=1; j<=2*N-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
