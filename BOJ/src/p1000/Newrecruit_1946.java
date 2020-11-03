/**
 * Backjoon - 1946. 신입 사원
 * Newrecruit_1946.java
 * @date 2020-09-16
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade>{
	int x;
	int y;
	
	public Grade(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Grade o) {
		return Integer.compare(this.x, o.x);
	}
}

public class Newrecruit_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int answer = N;
			ArrayList<Grade> grades = new ArrayList<>();
			 
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				grades.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// x좌표 기준 오름차순 정렬
			Collections.sort(grades);
			int minY = grades.get(0).y;
			for(int i=1; i<N; i++) {
				if(grades.get(i-1).x < grades.get(i).x && minY < grades.get(i).y) {
					answer--;
					continue;
				}
				minY = Math.min(minY, grades.get(i).y);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
