/**
 * Backjoon - 1193. 분수 찾기
 * FindFraction_1193.java
 * @date 2020-08-19
 * @author hansolKim
 **/

package p1000;

import java.util.Scanner;

public class FindFraction_1193 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int jump = 1;
		int level = 1;
		int x, y;
		
		int N = sc.nextInt();
		
		while(N>0) {
			N-=(jump*level);
			level++;
		}
		
		int dist = Math.abs(N);
		
		if((level-1) % 2 == 0) {
			x = level-1-dist;
			y = 1+dist;
		} else {
			x = 1+dist;
			y = level-1-dist;
		}
		
		System.out.println(x+"/"+y);
		
	}

}
