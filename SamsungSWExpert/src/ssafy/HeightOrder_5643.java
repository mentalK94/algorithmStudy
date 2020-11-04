/**
 * Samsung SW Expert - 5643. 키 순서
 * HeightOrder_5643.java
 * @date 2020-11-04
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeightOrder_5643 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			int n = Integer.parseInt(br.readLine()); // 학생 수
			int m = Integer.parseInt(br.readLine()); // 비교 수
			
			int[][] map = new int[n+1][n+1];
			
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a][b] = 1;
			}
			
			for(int k=1; k<=n; k++) { // 경유지 
				for(int i=1; i<=n; i++) { // 출발지
					for(int j=1; j<=n; j++) { // 도착지
						if(map[i][j] == 1) continue;
						if(map[i][k] == 1 && map[k][j] == 1) {map[i][j] = 1;}
					}
				}
			}
			
			int answer = 0;
			main:for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i == j) continue;
					if(map[i][j] == 0 && map[j][i] == 0) {
						continue main;
					}
				}
				answer++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
