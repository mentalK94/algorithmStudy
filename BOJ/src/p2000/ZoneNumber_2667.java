/**
 * Backjoon - 2667. 단지번호 붙이기
 * ZoneNumber.java
 * @date 2020-08-05
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ZoneNumber_2667 {

	private static int N; // 지도의 크기
	private static int[][] map; // 지도
	private static boolean[][] isVisited; // 방문여부
	private static int number = 0; // 단지 수
	private static int count = 0; // 단지 집 개수
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static ArrayList<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 지도의 크기 입력
		
		map = new int[N][N];
		isVisited = new boolean[N][N];	
		list = new ArrayList<Integer>();
		
		/* map 상태입력 */
		for(int i=0; i<N; i++) {
			
			String state = br.readLine();
			
			for(int j=0; j<N; j++) {
				map[i][j] = state.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 방문하지 않았고 집이 있는 경우
				if(!isVisited[i][j] && map[i][j] == 1) {
					number++;
					count = 0;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(number);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

	private static void dfs(int x, int y) {
		
		isVisited[x][y] = true;
		map[x][y] = number;
		count++;
		
		for(int i=0; i<4; i++) {
			
			int rx = x + dx[i];
			int ry = y + dy[i];
			
			/* 지도안에 존재함과 동시에 집이 있고 방문하지 경우 */
			if(isInMap(rx, ry)) {
				if(map[rx][ry] == 1 && !isVisited[rx][ry]) {
					dfs(rx, ry);
				}
			}
		}
		
	}

	private static boolean isInMap(int rx, int ry) {
		return (rx>=0 && rx<N && ry>=0 && ry<N) ? true : false;
	}

}
