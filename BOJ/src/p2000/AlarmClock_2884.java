/**
 * Backjoon - 2884. 알람 시계
 * AlarmClock.java
 * @date 2020-08-05
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

public class AlarmClock_2884 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		if(m >= 45) {
			m-=45;
		} else {
			m+=15;			
			if(h>0) {
				h-=1;
			} else {
				h = 23;
			}
		}
		
		System.out.println(h + " " + m);
	}

}
