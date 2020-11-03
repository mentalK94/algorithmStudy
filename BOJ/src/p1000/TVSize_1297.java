/**
 * Backjoon - 1297. TV크기
 * TVSize_1297.java
 * @date 2020-09-19
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TVSize_1297 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 대각선의 비율
		int x = Integer.parseInt(st.nextToken()); // 높이의 비율
		int y = Integer.parseInt(st.nextToken()); // 너비의 비율		
		
		int xx = x * x;
		int yy = y * y;
		int rr = r * r;
		double ratio = (double) rr / (double) (xx + yy);
		System.out.println((int) Math.sqrt(ratio * xx) + " " + (int) Math.sqrt(ratio * yy));
	}

}
