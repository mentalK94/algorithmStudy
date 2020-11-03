/**
 * Backjoon - 10250. ACM 호텔
 * ACMHotel_10250.java
 * @date 2020-08-20
 * @author hansolKim
 **/

package p10000;

import java.util.Scanner;

public class ACMHotel_10250 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();		
		
		for(int i=0; i<T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int floor = (N%H != 0) ? N%H : H;
			int number = (int) Math.ceil((double)N/(double)H);
			sb.append(floor);
			sb.append(String.format("%02d", number));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
