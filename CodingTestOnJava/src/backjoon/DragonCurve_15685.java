/**
 * Backjoon - 15685. 드래곤 커브
 * DragonCurve_15685.java
 * @date 2020-10-18
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class DragonCurve_15685 {

	static boolean[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int generation, d;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());			
			d = Integer.parseInt(st.nextToken());
			generation = Integer.parseInt(st.nextToken());
			
			map[startX][startY] = true;
			dragonCurve(startX, startY);
			System.out.println();
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

	private static void dragonCurve(int x, int y) {
		
		Stack<Integer> dirStack = new Stack<>();
		dirStack.add(d);
		int curX = x;
		int curY = y;
		
		for(int i=0; i<=generation; i++) {
			ArrayList<Integer> originDirs = new ArrayList<>();
			ArrayList<Integer> newDirs = new ArrayList<>();
			while(!dirStack.isEmpty()) {
				int dir = dirStack.pop();
				System.out.println(dir);
				originDirs.add(dir);
				
				// 원본 방향전환
				int newDir = (dir+1)%4;
				newDirs.add(newDir);
				
				curX = curX + dx[newDir];
				curY = curY + dy[newDir];
				
				if(curX<0 || curX>=101 || curY<0 || curY>=101) continue;
				
				map[curX][curY] = true;
			}
						
			for(int j=originDirs.size()-1; j>=0; j--) {
				dirStack.add(originDirs.get(j));
			}
			
			for(int j=originDirs.size()-1; j>=0; j--) {
				dirStack.add(newDirs.get(j));
			}
			
			System.out.println();
		}
	}

}
