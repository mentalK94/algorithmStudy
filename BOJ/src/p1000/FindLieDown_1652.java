/**
 * Backjoon - 1652. 누울 자리를 찾아라
 * FindLieDown_1652.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindLieDown_1652 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int vertical = 0;
		int horizontal = 0;
		
		// 가로 탐색
		for(int i=0; i<map.length; i++) {
			int verticalCnt = 0;
			int horizontalCnt = 0;
			int verticalTemp = 0;
			int horizontalTemp = 0;
			
			for(int j=0; j<map[i].length; j++) {
				
				if(map[i][j] == '.') {
					horizontalCnt++;
					if(horizontalCnt == 2) { horizontalTemp++; }
				} else {
					horizontalCnt = 0;
				}
				
				if(map[j][i] == '.') {
					verticalCnt++;
					if(verticalCnt == 2) { verticalTemp++; }
				} else {
					verticalCnt = 0;
				}
				
			}
			
			horizontal += horizontalTemp;
			vertical += verticalTemp;
		}
		
		System.out.println(horizontal + " " + vertical);
	}

}
