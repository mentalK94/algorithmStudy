/**
 * Backjoon - 2635. 수 이어가기
 * ContinuingNumber_2635.java
 * @date 2020-09-22
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContinuingNumber_2635 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		
		int maxCnt = 0;
		int minus = 0;

		list.add(num);

		while (true) {
			int second = num - minus++;	
			if (second <= 0) {
				break;
			}
			list.add(second);

			int first = num;
			while (first - second >= 0) {
				int temp = first-second;
				list.add(temp);
				first = second;
				second = temp;
			}
			if(maxCnt <= list.size()) {
				int size = list.size();
				maxCnt = size;
				answer = (ArrayList<Integer>) list.clone();
			} else {				
				break;
			}
			list.clear();
			list.add(num);
		}
		
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}

	}

}
