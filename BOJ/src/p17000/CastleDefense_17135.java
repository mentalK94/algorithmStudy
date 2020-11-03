/**
 * Backjoon - 17135. 캐슬 디펜스
 * CastleDefense_17135.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CastleDefense_17135 {

	private static int N, M, D; // 행의 수 N, 열의 수 M, 공격 거리 제한 D
	private static int R = 3; // 궁수 3명
	private static int[][] map; // 격자판
	private static int[][] tempMap; // 임시 격자판
	private static int maxKillCount = 0; // 제거할 수 있는 적의 최대 수
	private static int[] selected; // 선택된 배치 번호
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer init = new StringTokenizer(br.readLine());
		selected = new int[3];
		
		N = Integer.parseInt(init.nextToken());
		M = Integer.parseInt(init.nextToken());
		D = Integer.parseInt(init.nextToken());
		
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer enemy = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(enemy.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(maxKillCount);
	}
	
	/* 거리 계산 메서드 */
	public static int getDistance(int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x1-x2);
		int dy = Math.abs(y1-y2);
		
		return dx+dy;
	}
	
	/* 궁수를 배치하는 가지 수 계산(조합) */
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			// 궁수의 좌표와 적의 좌표가 주어질 때 제거 할 수 있는 적의 수
			int count = getKillCount();
			maxKillCount = Math.max(maxKillCount, count);
			return;
		}
		
		for(int i=start; i<M; i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	/* 궁수가 적을 처치하는 로직 */
	private static int getKillCount() {
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			
			q = new LinkedList<>();
			
			for(int j=0; j<3; j++) {
				int x = -1;
				int y = -1;
				int minDistance = D+1;
				
				for(int k=0; k<N-i; k++) {
					for(int t=0; t<M; t++) {
						int dist = getDistance(N-i, selected[j], k, t); // 궁수와 적 위치 거리 계산
						if(dist <= D && tempMap[k][t] >= 1) {
							// 거리가 더 가깝거나, 같은 거리에서 더 왼쪽의 적을 찾은 경우 -> 갱신
							if(dist < minDistance) {
								minDistance = Math.min(minDistance, dist); // 최소 거리 갱신
								x = k; y = t; // 공격할 적의 좌표
								continue;
							}
							
							if(dist == minDistance && t<y) {
								x = k; y = t; // 공격할 적의 좌표
							}
						}
					}					
				}
				
				if(x == -1 && y == -1) { // 죽일 적을 찾지 못한 경우
					continue;
				}
				
				q.offer(new int[] {x, y}); // 적을 죽인 x, y좌표 저장
				tempMap[x][y]++; // x, y좌표에 적을 죽인 횟수 추가
				if(tempMap[x][y] == 2) // 적을 여러번 죽인 경우 count배제
					count++;	
			}
			
			while(!q.isEmpty()) { // 적을 죽인 위치에 적이 없다고 가정
				int x = q.peek()[0];
				int y = q.peek()[1];
				
				q.poll();
				tempMap[x][y] = 0;
			}
		}
		
		return count;
	}
}
