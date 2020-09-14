/**
 * Backjoon - 1018. 체스판 다시 칠하기
 * BigSize_1018.java
 * @date 2020-09-15
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChessBoardReprint {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[m][n];
		
		for(int i=0; i<m; i++) {			
			board[i] = br.readLine().toCharArray();
		}
		
		int answer = 64;
		
		for(int i=0; i<m-7; i++) {			
			for(int j=0; j<n-7; j++) {
				char startColor = board[i][j];
				int equalCnt = 64;
				int notEqualCnt = 64;
				int init=(i+j)%2;
				for(int k=i; k<8+i; k++) {							
					for(int t=j; t<8+j; t++) {
						if((k+t)%2==init) {
							if(board[k][t] == startColor) {
								equalCnt--;
							}
						} else {
							if(board[k][t] != startColor) {
								equalCnt--;
							}
						}
						
						if((k+t)%2!=init) {
							if(board[k][t] == startColor) {
								notEqualCnt--;
							}
						} else {
							if(board[k][t] != startColor) {
								notEqualCnt--;
							}
						}
					}
				}
				
				answer = Math.min(answer, equalCnt);
				answer = Math.min(answer, notEqualCnt);
			}
		}
		
		System.out.println(answer);
	}

}
