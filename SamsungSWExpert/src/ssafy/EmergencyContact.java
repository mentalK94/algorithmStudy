package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EmergencyContact {
	
	private static int SIZE;
	private static int START;
	private static boolean matrix[][];
	private static int visited[];
	private static int value = 0;
	private static int answer = 0;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#"+test_case + " ");
			
			StringTokenizer init = new StringTokenizer(br.readLine());
			
			SIZE = Integer.parseInt(init.nextToken());
			START = Integer.parseInt(init.nextToken());
			matrix = new boolean[SIZE+1][SIZE+1];
			
			StringTokenizer fromTo = new StringTokenizer(br.readLine());
			
			for(int i=0; i<fromTo.countTokens();) {
				int from = Integer.parseInt(fromTo.nextToken());
				int to = Integer.parseInt(fromTo.nextToken());
				matrix[from][to] = true;
			}
			
			answer = 0;
			bfs(START);
			
			sb.append(answer+"\n");
	
		}
		System.out.println(sb);
	}
	
	// 나와서 방문 처리
	private static void bfs(int start) {
		Queue<Integer>  queue = new LinkedList<Integer>();
		visited = new int[SIZE+1];
		
		queue.offer(start);
		visited[start] = 1; 	// 방법2 : 들어갈때 방문 처리		
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i=0; i<SIZE; ++i) {

				if(matrix[current][i] 
						&& visited[i] == 0) {
					queue.offer(i);
					visited[i] = visited[current]+1; 	// 방법2 : 들어갈때 방문 처리
				}
			}					
		}
		
		value = 0;
		
		for(int i=1; i<SIZE+1; i++) {
			if(value <= visited[i]) {
				answer = i;
				value = visited[i];
			}
		}
	}
}
