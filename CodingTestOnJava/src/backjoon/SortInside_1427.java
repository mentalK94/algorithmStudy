/**
 * Backjoon - 1427. 좌표 정렬하기
 * SortInside_1427.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SortInside_1427 {

	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while(N > 0) {
			list.add(N%10);
			N/=10;
		}
		
		Collections.sort(list, Comparator.reverseOrder());
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
