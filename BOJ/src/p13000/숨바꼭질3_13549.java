/**
 * Backjoon - 13549. 숨바꼭질
 * 숨바꼭질3_13549.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p13000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		int answer = 0;
		q.add(new int[]{N, 0});
		while(!q.isEmpty()) {			
			int cur = q.peek()[0];
			int time = q.poll()[1];
			
			if(cur<0 || cur>100000) { continue;}
			if(visited[cur]) {continue;}
			
			visited[cur] = true; // 방문처리
			
			if(cur == K) { // 동생을 찾은 경우 
				answer = time;
				break;
			}

			{q.add(new int[] {cur*2, time});}
			{q.add(new int[] {cur-1, time+1});}
			{q.add(new int[] {cur+1, time+1});}
		}
		
		System.out.println(answer);
		br.close();
	}
}