/**
 * Backjoon - 4963. 섬의 갯수
 * CountIsland.java
 * @date 2020-08-05
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountIsland_4963 {

	private static int w, h;
	private static int[][] map;
	private static int dx[] = {-1,-1,-1,0,0,1,1,1};
	private static int dy[] = {-1,0,1,-1,1,-1,0,1};
	private static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			StringTokenizer init = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(init.nextToken());
			h = Integer.parseInt(init.nextToken());
			
			if(w == 0 && h == 0) { break;} // 기저조건
			
			map = new int[h][w];
			count = 0;
			
			for(int i=0; i<h; i++) {
				StringTokenizer islandState = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(islandState.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
			
		}
		
		System.out.println(sb);
		
	}

	private static void dfs(int x, int y) {
		
		map[x][y] = 0; // 방문 표기
		
		for(int i=0; i<8; i++) {
			
			int rx = x+dx[i];
			int ry = y+dy[i];
			
			if(isInMap(rx, ry)) {
				if(map[rx][ry] == 1) {
					dfs(rx, ry);
				}
			}
		}
	}

	private static boolean isInMap(int rx, int ry) {
		return (rx>=0 && rx<h && ry>=0 && ry<w) ? true : false;
	}

}
