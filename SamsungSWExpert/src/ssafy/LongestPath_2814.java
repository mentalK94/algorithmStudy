/**
 * Samsung SW Expert - 2814. 최장 경로
 * LongestPath_2814.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestPath_2814 {

	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new int[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			
			int answer = 1;
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				
				visited[i] = true;
				cnt = dfs(i, 1);
				
				if(answer < cnt) { answer = cnt; }
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int dfs(int x, int cnt) {
		// System.out.println(x);
		visited[x] = true;
		int result = 1;
		int temp = 0;
		
		for(int i=1; i<=N; i++) {
			if(graph[x][i] == 1 && !visited[i]) {
				visited[i] = true;
				temp = dfs(i, cnt+1);
				if(result < temp) { result = temp; }
				visited[i] = false;
			}
		}
		return result>cnt ? result:cnt;
	}

}
