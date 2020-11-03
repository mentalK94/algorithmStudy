/**
 * Backjoon - 1436. 영화감독 숌
 * MovieDirector_1436.java
 * @date 2020-09-29
 * @author hansolKim
 **/

package p1000;

import java.util.Scanner;

public class MovieDirector_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
			
		int order = 0;
		int number = 0;
		
		while(true) {
			number++;
			String str = String.valueOf(number);
			if(str.contains("666")) {
				order++;
			}
			
			if(order == n) {
				System.out.println(number);
				return;
			}
		}
	}

}
