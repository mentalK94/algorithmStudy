/**
 * Backjoon - 1006. 습격자 초라기
 * 습격자초라기_1006.java
 * @date 2020-12-20(실패)
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 습격자초라기_1006 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 구역 개수
			int W = Integer.parseInt(st.nextToken()); // 소대원 수
			
			int[][] area = new int[2][N];
			// 1층의 1구역부터 검사
			for(int i=0; i<2; i++) {
				for (int j = 0; j < N; j++) {
					int floor = -1;
					int selectedArea = -1;
					int sum = 0;
					// 이전 구역
					int prev = j-1==-1 ? N-1:j-1;
					// 이전 구역이 침투되지 않았고 현재 구역과 이전구역의 합이 소대원 수보다 작거나 같은 경우
					if(area[i][prev] != 0 && area[i][j] + area[i][prev] <= W) {
						floor = i;
						selectedArea = prev;
						sum = area[i][j] + area[i][prev];
					}
				}
			}
			
		}
	}

}
