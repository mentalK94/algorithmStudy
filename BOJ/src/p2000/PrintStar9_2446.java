/**
 * Backjoon - 2446. 별 찍기 - 9
 * PrintStar9_2446.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class PrintStar9_2446 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N-1; i++) {
			if(i<=N) {
				for(int j=1; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=1; j<=2*N-(2*i)+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for(int j=1; j<=2*N-1-i; j++) {
					System.out.print(" ");
				}
				for(int j=1; j<=2*i-2*N+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
