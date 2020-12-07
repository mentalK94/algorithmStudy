/**
 * Backjoon - 1004. 어린 왕자
 * LittlePrince_1004.java
 * @date 2020-12-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LittlePrince_1004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				double dist1 = getDist(cx, cy, x1, y1);
				double dist2 = getDist(cx, cy, x2, y2);
				
				if(dist1<=r || dist2<=r) { cnt++; }
				if(dist1<=r && dist2<=r) { cnt--; }
			}
			
			sb.append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static double getDist(int cx, int cy, int x, int y) {
		return Math.sqrt((cx-x)*(cx-x) + (cy-y)*(cy-y));
	}

}
