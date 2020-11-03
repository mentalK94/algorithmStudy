/**
 * Backjoon - 1712. 손익분기점
 * BreakEvenPoint_1712.java
 * @date 2020-08-12
 * @author hansolKim
 **/

package p1000;

import java.util.Scanner;

public class BreakEvenPoint_1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(B>=C) { // 손익분기점이 존재하지 않는 경우
			System.out.println(-1);
			return;
		} 
		
		int answer = 0;
		long cost = A;
		long income = 0;
		
		while(true) {
			if(cost<income) {break;}
			
			cost+=B;
			income+=C;
			
			answer++;
		}
		
		System.out.println(answer);
	}
}
