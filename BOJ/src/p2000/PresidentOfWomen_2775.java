/**
 * Backjoon - 2775. 부녀회장이 될테야
 * PresidentOfWomen_2775.java
 * @date 2020-08-21
 * @author hansolKim
 **/

package p2000;

import java.util.Scanner;

class PresidentOfWomen_2775 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[15][15];
		
		for(int i=1; i<15; i++) {
			map[0][i] = i;
		}
		
		for(int i=1; i<15; i++) { // 1층부터 순회
			for(int j=1; j<15; j++) {  
				for(int k=1; k<=j; k++) {  
					map[i][j] += map[i-1][k];
				}
			}
		}	
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			sb.append(map[K][N] + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
