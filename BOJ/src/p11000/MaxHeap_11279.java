/**
 * Backjoon - 11279. 최대 힙
 * MaxHeap_11279.java
 * @date 2020-11-30
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap_11279 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.size() == 0) {
					sb.append(0);
				} else {
					int max = pq.poll();
					sb.append(max);
				}
				sb.append("\n");
			} else {
				pq.add(num);
			}
		}
		
		System.out.println(sb);
		br.close();

	}

}
