/**
 * Backjoon - 2578. 빙고
 * Bingo_2578.java
 * @date 2020-09-19 
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo_2578 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] bingo = new int[5][5];
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[25];
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				order[5*i+j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<order.length; i++) {
			int number = order[i]; // 사회자가 부른 번호
			
			// 사회자가 부르는 수 표기
			bingo:for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					if(number == bingo[j][k]) {
						bingo[j][k] = -1; // 부르는 수 표기
						break bingo;
					}
				}
			}
			
			// 3개의 빙고를 완성하려면 사회자가 최소 12개의 번호를 불러야 한다
			int answer = 0;
			if((i+1)>=12) {
				boolean isBingo = true;
				// 가로빙고 확인
				for(int j=0; j<5; j++) {
					isBingo = true;
					line:for(int k=0; k<5; k++) {
						if(bingo[j][k] != -1) {
							isBingo = false;
							break line;
						}
					}
					if(isBingo) answer++;					
				}
				
				// 세로빙고 확인
				for(int j=0; j<5; j++) {
					isBingo = true;
					line:for(int k=0; k<5; k++) {
						if(bingo[k][j] != -1) {
							isBingo = false;
							break line;
						}
					}
					if(isBingo) {
						answer++;					
					}
				}
				
				isBingo = true;
				// 왼쪽 대각선 빙고 확인
				for(int j=0; j<5; j++) {
					if(bingo[j][j] != -1) {
						isBingo = false;
						break;
					}
				}
				if(isBingo) answer++;
				
				isBingo = true;
				// 오른쪽 대각선 빙고 확인
				for(int j=0; j<5; j++) {
					if(bingo[j][4-j] != -1) {
						isBingo = false;
						break;
					}
				}
				if(isBingo) answer++;
			}
			
			if(answer >= 3) {
				System.out.println(i+1);
				return;
			}
		}
	}

}
