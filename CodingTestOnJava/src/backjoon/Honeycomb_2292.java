/**
 * Backjoon - 2292. 벌집
 * Honeycomb_2292.java
 * @date 2020-08-19
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class Honeycomb_2292 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int answer = 1;
		int jump = 6;
		int level = 6;
		
		int N = sc.nextInt()-1;
		
		while(N>0) {
			N-=jump;
			jump += level;
			answer++;
		}
		System.out.println(answer);
	}

}
