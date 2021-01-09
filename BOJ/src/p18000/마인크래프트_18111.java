/**
 * Backjoon - 18111. 마인크래프트
 * 마인크래프트_18111.java
 * @date 2021-01-07
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // N행
		int m = Integer.parseInt(st.nextToken()); // M열
		int b = Integer.parseInt(st.nextToken()); // 현재 가지고 있는 블록 수

		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answerH = 0;
		int time = Integer.MAX_VALUE;
		
		// 높이가 0에서부터 256까지 전부 고려해서 해보기
		for(int h=0; h<=256; h++) {
			int build = 0; // 지어야 하는 블록
			int remove = 0; // 제거해야 하는 블록
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]-h>=0) { remove += map[i][j]-h;} // 제거해야하는 블록 수 추가
					else { 
						build += (h-map[i][j]);
					} // 지어야하는 블록 수 추가
				}
			}
			
			// 지어야하는 블록의 수만큼 충분히 블록을 가지고 있는 지
			if(remove+b>=build) {
				if(build + remove*2 <= time) { // 기존의 시간보다 짧거나 같을 때
					time = build + remove*2;
					answerH = h;
				}
			} else { // 지어야하는 블록의 수가 부족한 경우 -> h를 높여도 블록의 수는 항상 부족하다
				break;
			}
		}
		
		System.out.println(time + " " + answerH);
	}

}
