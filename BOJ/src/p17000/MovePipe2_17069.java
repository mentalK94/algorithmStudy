/**
 * Backjoon - 17069. 파이프 옮기기 2
 * MovePipe2_17069.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePipe2_17069 {

	static int N;
	static int[][] map;
	static long[][][] memory;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	static long answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		memory = new long[N+1][N+1][3];
		answer = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memory[0][1][0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				
				// 가로인 경우
				if(map[i][j+1] == 0) { memory[i][j+1][0] += (memory[i][j][0] + memory[i][j][2]);} // 가로 혹은 대각선
				// 세로인 경우
				if(map[i+1][j] == 0) { memory[i+1][j][1] += (memory[i][j][1] + memory[i][j][2]);} // 세로 혹은 대각선
				// 대각선인 경우
				if(map[i+1][j+1] == 0 && map[i+1][j] == 0 && map[i][j+1] == 0) { 
					memory[i+1][j+1][2] += (memory[i][j][0] + memory[i][j][1] + memory[i][j][2]);
				} // 가로, 세로, 대각선 모두
				
			}
		}
		
		answer = memory[N-1][N-1][0] + memory[N-1][N-1][1] + memory[N-1][N-1][2]; 
		
		System.out.println(answer);
	}
}
