/**
 * Backjoon - 1927. 최소 힙
 * MinHeap_1927.java
 * @date 2020-11-30
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.size() == 0) {
					sb.append(0);
				} else {
					int min = pq.poll();
					sb.append(min);
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
