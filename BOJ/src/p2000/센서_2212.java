/**
 * Backjoon - 2212. 센서
 * 센서_2212.java
 * @date 2021-01-24
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센서_2212 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] censors = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			censors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(censors);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=1; i<censors.length; i++) {
			pq.add(censors[i]-censors[i-1]);
		}
		
		int answer = censors[censors.length-1] - censors[0];
		while(!pq.isEmpty() && --K>0) {
			answer -= pq.poll();
		}
		
		System.out.println(answer);
		br.close();
	}
}