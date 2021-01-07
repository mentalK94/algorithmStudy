/**
 * Backjoon - 1074. Z
 * Z_1074.java
 * @date 2021-01-07
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
	
	static int temp, answer, r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int destX = (int) Math.pow(2, n)-1;
		int destY = destX;
		
		temp = -1;
		visit(0, 0, destX, destY, n);

		System.out.println(answer);
		br.close();
	}

	private static void visit(int x, int y, int dX, int dY, int n) {
		
		if(!(x<=r && r<=dX && y<=c && c<=dY)) { // 범위안에 없다면 
			temp += Math.pow(2, n)*Math.pow(2, n);
			return;
		}
		
		if(n == 0) {
			temp++;
			if(x == r && y == c) { answer = temp; } 
			return;
		}
		
		int term = (int) Math.pow(2, n-1);
		
		// 좌상
		visit(x, y, dX-term, dY-term, n-1);
		// 우상
		visit(x, y+term, dX-term, dY, n-1);
		// 좌하
		visit(x+term, y, dX, dY-term, n-1);
		// 우하
		visit(x+term, y+term, dX, dY, n-1);
		
	}
}