/**
 * Backjoon - 2440. 별 찍기 - 3
 * PrintStar_2440.java
 * @date 2020-10-07
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class PrintStar_2440 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=n; i>0; i--) {
			for(int j=0; j<i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
