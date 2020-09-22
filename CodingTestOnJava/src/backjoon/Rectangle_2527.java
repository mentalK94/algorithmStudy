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

public class Rectangle_2527 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			// 1. 공통부분이 없는지 조사 --> d출력
			if((x4<x1) || (x2<x3) || (y4<y1) || (y2<y3)) {
				sb.append("d").append("\n");
				continue;
			}
			
			// 2. 한 점에서 만나는 경우 ---> c출력
			if((x1==x4 && y1==y4) || (x2==x3 && y2==y3) || 
					(x2==x3 && y1==y4) || (x1==x4 && y2==y3)) {
				sb.append("c").append("\n");
				continue;
			}
			
			// 3. 선분으로 만나는 경우 ---> b출력
			if((x1<x4 && x3<x2) && (y2==y3 || y1==y4) ||
					(y1<y4 && y3<y2) && (x2==x3 || x1==x4)) {
				sb.append("b").append("\n");
				continue;
			}
			
			// 4. 그 외 모두 직사각형이 된다.
			sb.append("a").append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
