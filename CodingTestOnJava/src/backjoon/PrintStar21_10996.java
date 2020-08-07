/**
 * Backjoon - 10996. 별 찍기 - 21
 * PrintStar21_10996.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class PrintStar21_10996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				if(j%2==0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
			
			for(int j=0; j<N; j++) {
				if(j%2==1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}

}
