/**
 * Backjoon - 10163. 색종이
 * ColoredPaper_10163.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoredPaper_10163 {
	
	private static int[][] paper;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		
		paper = new int[101][101];
		int area[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 색종이를 붙이는 행위
			attach(x, y, h, w, i);			
		}
		
		// 각 칠해진 공간 계산
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(paper[i][j] != 0) {
					area[paper[i][j]]++;
				}				
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(area[i]);
		}
	}

	private static void attach(int x, int y, int h, int w, int num) {
		for(int i=x; i<x+h; i++) {
			for(int j=y; j<y+w; j++) {
				paper[i][j] = num;
			}
		}
	}

}
