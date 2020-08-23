/**
 * Backjoon - 4153. 직각삼각형
 * RightAngledTriangle_1086.java
 * @date 2020-08-23
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RightAngledTriangle_1086 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == 0) {break;}
			
			if((z*z) == ((x*x)+(y*y))) {
				sb.append("right\n");
			} else if((y*y) == ((x*x)+(z*z))) {
				sb.append("right\n");
			} else if((x*x) == ((y*y)+(z*z))) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
