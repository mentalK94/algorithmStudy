/**
 * Backjoon - 11729. 하노이 탑
 * Hanoi_11729.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class Hanoi_11729 {

	private static int answer = 0;
	private static StringBuilder sb;
	
	public static void main(String[] args) {
		
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		hanoi(n, 1, 2, 3);
		
		System.out.println(answer);
		System.out.println(sb);
	}

	private static void hanoi(int n, int from, int help, int to) {
		
		if(n == 1) {
			sb.append(from + " " + to).append("\n");
			answer++;
			return;
		}
		
		// 1. n-1개를 보조 기둥으로 이동
		hanoi(n-1, from, to, help);
		
		// 가장 큰 원반을 목적지로 이동
		sb.append(from + " " + to).append("\n");
		answer++;
		
		// 2. n-1개를 보조 기둥에서 목표기둥으로 이동
		hanoi(n-1, help, from, to);
	}
	

}
