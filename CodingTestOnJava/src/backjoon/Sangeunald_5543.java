/**
 * Backjoon - 5543. 상근날드
 * Sangeunald_5543.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class Sangeunald_5543 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minBurger = Integer.MAX_VALUE;
		int minDrink = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {
			int n = sc.nextInt();
			minBurger = Math.min(minBurger, n);
		}
		
		for(int i=0; i<2; i++) {
			int n = sc.nextInt();
			minDrink = Math.min(minDrink, n);
		}
		
		System.out.println(minBurger + minDrink - 50);

	}

}
