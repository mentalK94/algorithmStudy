/**
 * Backjoon - 2468. 안전 영역
 * SafetySection_2468.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafetySection_2468 {

	private static int N; // 행과 열의 개수
	private static int[][] section; // 영역
	private static int[][] tempSection; // 임시 영역
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};
	private static int maxHeight = Integer.MIN_VALUE;
	private static int minHeight = Integer.MAX_VALUE;
	private static int safetySectionCount = 1; // 아무곳도 잠기지 않은 경우
	private static int tempCnt = 0; // 안전 영역 임시 카운트
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 행과 열 크기 입력
		
		section = new int[N][N];
		tempSection = new int[N][N];
		
		// 높이 입력
		for(int i=0; i<N; i++) {
			StringTokenizer state = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				section[i][j] = Integer.parseInt(state.nextToken());
				maxHeight = Math.max(maxHeight, section[i][j]);
				minHeight = Math.min(minHeight, section[i][j]);
			}
		}
		
		for(int idx=minHeight; idx<maxHeight; idx++) {
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					tempSection[i][j] = section[i][j]-idx;
				}
			}
			
			tempCnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(tempSection[i][j] > 0) {
						dfs(i, j);
						tempCnt++;
					}
				}
			}
			
			safetySectionCount = Math.max(safetySectionCount, tempCnt);
			
		}
		
		System.out.println(safetySectionCount);
	}

	private static void dfs(int x, int y) {
		tempSection[x][y] = 0; // 방문 표기
		
		for(int i=0; i<4; i++) {
			int rx = x+dx[i];
			int ry = y+dy[i];
			if(isInSection(rx, ry)) {
				if(tempSection[rx][ry] > 0) {
					dfs(rx, ry);
				}
			}
		}
	}

	private static boolean isInSection(int rx, int ry) {
		return (rx>=0 && rx<N && ry>=0 && ry<N);
	}

}
