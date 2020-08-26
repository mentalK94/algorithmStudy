/**
 * Backjoon - 2447. 별 찍기 - 10
 * PrintStar_10_2447.java
 * @date 2020-08-26
 * @author hansolKim
 **/

package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class PrintStar_10_2447 {

	private static StringBuilder sb;
	private static int N;
	static char arr[][]; //n크기만큼 2차원 배열을 생성한다.
	
	public static void main(String[] args) {
		
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		if(N==1) {
			System.out.println("*");
			return;
		}
		
		arr = new char[N][N];
		
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i],' ');
		}
		
		printStar(0, 0, N);
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void printStar(int x, int y, int n) {
		
		int div = 0;
		
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		div = n/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					continue;
				}
				printStar(x+(div*i), y+(div*j), div);
			}
		}
		
	}

}
