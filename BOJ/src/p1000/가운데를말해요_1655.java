/**
 * Backjoon - 10868. 최솟값
 * 최솟값_10868.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> right = new PriorityQueue<>(); // 중간값보다 큰 집합
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 중간값보다 작은 집합
		
		// 항상 right집합보다 left집합이 1개 더많거나 같아야한다
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 1. left.size == right.size인 경우 --> left에 추가
			if(left.size() == right.size()) {
				// 1-1. 현재 숫자가 오른쪽 집합의 최솟값보다 큰 경우 --> 오른쪽 최솟값을 왼쪽에다 삽입 후 현재 값 오른쪽에 삽입
				if(!right.isEmpty() && right.peek() < num) {
					left.add(right.poll());
					right.add(num);
				} else { 
					left.add(num);
				}
			} else { // 2. left.size가 더 큰 경우 ---> right 삽입
				// 2-1. 현재 숫자가 왼쪽 집합의 최댓값보다 작은 경우 ---> 왼쪽 최댓값을 오른쪽 집합에 삽입 후 현재 값 왼쪽에 삽입
				if(!left.isEmpty() && num < left.peek()) {
					right.add(left.poll());
					left.add(num);
				} else {
					right.add(num);
				}
			}
			
			sb.append(left.peek()).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}