/**
 * Backjoon - 2441. 별 찍기 - 4
 * PrintStar4_2441.java
 * @date 2020-10-09
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class PrintStar4_2441 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=N-i; j<N; j++) {
				sb.append(" ");
			}
			for(int j=i; j<N; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
