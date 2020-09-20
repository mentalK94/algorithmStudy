/**
 * Backjoon - 2563. 색종이
 * ColoredPaper_2563.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoredPaper_2563 {
	
	private static boolean[][] paper;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		paper = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 색종이를 붙이는 행위
			attach(x, y);			
		}
		
		// 칠해진 공간 계산
		int area = 0;
		for(int i=1; i<paper.length; i++) {
			for(int j=1; j<paper[i].length; j++) {
				if(paper[i][j] == true) {
					area++;
				}
			}	
		}
		
		// 결과 출력
		System.out.println(area);
	}

	private static void attach(int x, int y) {
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				paper[i][j] = true;
			}
		}
	}

}
