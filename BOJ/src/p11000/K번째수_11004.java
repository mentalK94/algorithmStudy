/**
 * Backjoon - 11004. K번째 수
 * K번째수_11004.java
 * @date 2021-01-14
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째수_11004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		while(N-->0) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		while(K-->0) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
		br.close();
	}
}