/**
 * Backjoon - 14889. 스타트와 링크
 * StartAndLink_14889.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink_14889 {

	static int N, R, answer;
	static int[][] map;
	static int[] startTeam, linkTeam;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		R = N/2;
		map = new int[N][N];
		startTeam = new int[R];
		linkTeam = new int[R];
		answer = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		makeTeam(0, 0);
		
		System.out.println(answer);
	}

	private static void makeTeam(int start, int cnt) {
		if(cnt == R) {
			
			int linkIdx = 0;
			int startIdx = 0;
			for(int i=0;i<N; i++) {
				if(startIdx<R && startTeam[startIdx] == i) {
					startIdx++;
				} else {
					linkTeam[linkIdx++] = i;
				}
			}
			
			int startValue = 0;
			int linkValue = 0;
			
			for(int i=0; i<R; i++) {
				int starter = startTeam[i];
				int linker = linkTeam[i];
				for(int j=0; j<R; j++) {
					if(i==j) continue;
					int startTarget = startTeam[j];
					int linkTarget = linkTeam[j];
					startValue += map[starter][startTarget];
					linkValue += map[linker][linkTarget];
				}
			}
			
			if(Math.abs(startValue-linkValue) < answer) {
				answer = Math.abs(startValue-linkValue);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			startTeam[cnt] = i;
			makeTeam(i+1, cnt+1);
		}
	}

}
