/**
 * Backjoon - 2437. 저울
 * 저울_2437.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 저울_2437 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] input = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) { 
			input[i] = Integer.parseInt(st.nextToken());
			pq.add(input[i]);
			
		}
		
		int sum = 0;
		while(!pq.isEmpty()) {
			int num = pq.poll();
			if(sum+1<num) { break;}
			sum += num;
		}
		
		System.out.println(sum+1);
		br.close();
	}

}
