/**
 * Backjoon - 15685. 드래곤 커브
 * DragonCurve_15685.java
 * @date 2020-10-18
 * @author hansolKim
 **/

package p15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DragonCurve_15685 {

	static boolean[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());			
			int d = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());
			
			map[startX][startY] = true;
			dragonCurve(startX, startY, d, generation);
		}
		
		int answer = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == true && map[i][j+1] == true && map[i+1][j] == true && map[i+1][j+1] == true) {
					// System.out.println(i + " " + j);
					answer++;
				}  
			}
		}
		
		System.out.println(answer);
	}

	private static void dragonCurve(int x, int y, int d, int generation) {
		
		ArrayList<Integer> dirs = new ArrayList<>();
		dirs.add(d);
		int curX = x + dx[d];
		int curY = y + dy[d];
		map[curX][curY] = true;
		
		for(int i=1; i<=generation; i++) {
			
			for(int j=dirs.size()-1; j>=0; j--) {
				int dir = dirs.get(j);
				
				// 원본 방향전환
				int newDir = (dir+1)%4;
				dirs.add(newDir);
				
				curX = curX + dx[newDir];
				curY = curY + dy[newDir];
				
				if(curX<0 || curX>=101 || curY<0 || curY>=101) continue;
				
				map[curX][curY] = true;
				
			}
		
		}
	}

}
