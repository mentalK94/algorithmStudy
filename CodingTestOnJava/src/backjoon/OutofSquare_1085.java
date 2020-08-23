/**
 * Backjoon - 1085. 직사각형에서 탈출
 * OutofSquare_1085.java
 * @date 2020-08-23
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OutofSquare_1085 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int answer = (w-x <= h-y) ? w-x : h-y;
		int answer2 = (x <= y) ? x : y;
		answer = (answer <= answer2) ? answer : answer2;
		
		System.out.println(answer);
		
	}

}
