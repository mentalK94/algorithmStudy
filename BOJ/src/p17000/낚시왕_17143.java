/**
 * Backjoon - 17143. 낚시왕
 * 낚시왕_17143.java
 * @date 2020-12-29
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕_17143 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 상어의 수
		
		int[][] map = new int[R][C];
		Queue<int[]> sharks = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		
		// 상어의 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; // 상어의 x위치
			int c = Integer.parseInt(st.nextToken())-1; // 상어의 y위치
			int s = Integer.parseInt(st.nextToken()); // 상어의 속력
			int d = Integer.parseInt(st.nextToken()); // 상어의 이동방향 
			int z = Integer.parseInt(st.nextToken()); // 상어의 크기
			
			map[r][c] = z;
			temp.add(new int[] {r, c, s, d, z});
		}
		
		Collections.sort(temp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[4], o1[4]);
			}
		});
		
		for(int[] shark : temp) {
			sharks.add(shark);
		}
		
		int cnt = 0;
		int row = -1;
		
		while(++row<C) { // 1. 낚시왕 오른쪽으로 한 칸 이동
			// 2. 낚시왕이 있는 열에 상어 중에서 땅과 제일 가까운 상어를 잡음.			
			int x = -1;
			int y = -1;
			for(int i=0; i<R; i++) {
				if(map[i][row] > 0) {
					cnt += map[i][row]; // 상어의 크기만큼 추가
					map[i][row] = 0; // 해당 칸 0으로 초기화
					x = i;
					y = row;
					break;
				}
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = 0;
				}
			}
			
			// 3. 상어의 이동구현
			int len = sharks.size();
			for(int i=0; i<len; i++) {
				int curX = sharks.peek()[0];
				int curY = sharks.peek()[1];
				int speed = sharks.peek()[2];
				int curDir = sharks.peek()[3];
				int size = sharks.poll()[4];
				
				if(curX == x && curY == y) { continue; } // 잡아먹힌 상어인 경우
				
				int move = speed;
				while(move-->0) { // speed만큼 이동
					if(curDir <= 2) {
						curX = curDir == 1 ? curX-1 : curX+1;
						if(curX == -1) {
							curX = 1;
							curDir = curDir==1 ? 2 : 1; // 방향 전환
						}
						if(curX == R) {
							curX = R-2;
							curDir = curDir==1 ? 2 : 1; // 방향 전환
						}
					} else {
						curY = curDir == 4 ? curY-1 : curY+1;
						if(curY == -1) {
							curY = 1;
							curDir = curDir==3 ? 4 : 3; // 방향 전환
						}
						if(curY == C) {
							curY = C-2;
							curDir = curDir==3 ? 4 : 3; // 방향 전환
						}
					}
				}
				
				if(map[curX][curY] != 0) {
					continue; 
				} // 이미 상어가 있는 경우
				
				map[curX][curY] = size; // 상어 사이즈 정보 입력
				sharks.add(new int[] {curX, curY, speed, curDir, size});
			}						
		}
		
		System.out.println(cnt);
		br.close();
	}
}