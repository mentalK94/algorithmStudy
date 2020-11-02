/**
 * Samsung SW Expert - 5656. 벽돌 깨기
 * BreakBrick_5656.java
 * @date 2020-11-02
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakBrick_5656 {

	static int N, W, H, answer;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {			

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] h = new int[W];
			for(int i=0; i<W; i++) {h[i] = -1;}
			getHArr(map, h);
			
			answer = Integer.MAX_VALUE;
			game(map, h, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void game(int[][] map, int[] h, int cnt) {
		
		if(cnt == N) { // N번의 기회를 모두 사용한 경우
			int brickCnt = getCnt(map);
			answer = brickCnt<answer ? brickCnt:answer;
			return;
		}
		
		int[][] tempMap = new int[H][W];
		int[] tempH = new int[W];
		
		// 배열 복사
		for(int i=0; i<H; i++) {
			tempMap[i] = map[i].clone();
		}
		
		tempH = h.clone();
		
		// 첫번째 열부터 마지막 열까지 쏘는 경우 모두 확인(해당 열에 벽돌이 없는 경우 제외)
		for(int i=0; i<W; i++) {
			
			if(tempH[i] == -1) { continue; } // 해당 열에 벽돌이 없는 경우 -> 구슬을 쏴도 소용이 없으므로 패스
			
			// i번째 열에서 구슬을 쏜 경우
			brick(tempMap, tempH[i], i);
			// 중간에 떠있는 벽돌 아래로 내림
			setArrange(tempMap);
			// 각 열마다 가장 윗쪽 벽돌 위치 셋팅
			getHArr(tempMap, tempH);

			// i번째 쏜 상태의 배열을 그대로 가지고 다음 순서로 전달
			game(tempMap, tempH, cnt+1);
			
			// 임시배열 값 되돌리기
			for(int j=0; j<H; j++) {
				tempMap[j] = map[j].clone();
			}
			
			tempH = h.clone();
		}
	}
	
	private static void brick(int[][] map, int x, int y) {
		
		// 현재 벽돌을 깸
		int weight = map[x][y]; // 벽돌의 영향계수
		map[x][y] = 0;
		
		// 영향계수가 1인 경우 주위에 영향을 주지 않음
		if(weight == 1) {return;}
		
		for(int i=0; i<4; i++) {
			for(int j=1; j<weight; j++) {
				int nx = x+dx[i]*j;
				int ny = y+dy[i]*j;
				
				// 영역 밖으로 벗어난 경우
				if(nx<0 || nx>=H || ny<0 || ny>=W) break;
				
				// 벽돌이 있는 경우
				if(map[nx][ny] != 0) {
					brick(map, nx, ny);
				}
			}
		}
	}

	// 남은 벽돌의 갯수를 구하는 함수
	private static int getCnt(int[][] map) {
		int cnt = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) {cnt++;} 
			}
		}
		
		return cnt;
	}
	
	private static void getHArr(int[][] map, int[] h) {
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(map[j][i] != 0) {
					h[i] = j;
					break;
				}
			}
		}
	}
	
	// 벽돌 정렬
	private static void setArrange(int[][] map) {
		for(int i=0; i<W; i++) {
			for(int j=H-1; j>=0; j--) {
				// 현재 칸에 숫자가 있다면 패스
				if(map[j][i] != 0) {continue;}
				// 현재 칸에 숫자가 없다면 현재  칸을 기준으로 윗쪽 탐색
				for(int k=j-1; k>=0; k--) {
					// 해당 칸에 숫자가 존재하는 경우 --> j칸의 위치로 이동 후 0으로 세팅
					if(map[k][i] != 0) {
						map[j][i] = map[k][i];
						map[k][i] = 0;
						break;
					}
				}
			}
		}
	}

}
