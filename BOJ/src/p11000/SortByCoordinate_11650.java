/**
 * Backjoon - 11650. 좌표 정렬하기
 * SortByCoordinate_11650.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortByCoordinate_11650 {
	
	static class Coordinate implements Comparable<Coordinate>{
		int x, y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o) {
			// y좌표 오름차순, 동일한 경우 x좌표 오름차순
			if(Integer.compare(this.x, o.x) == 0) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Coordinate> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Coordinate(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<N; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
		
	}
}
