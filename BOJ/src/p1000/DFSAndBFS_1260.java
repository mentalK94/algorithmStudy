/**
 * Backjoon - 1260. DFS와 BFS
 * DFSAndBFS_1260.java
 * @date 2020-10-22
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSAndBFS_1260 {

	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			sb.append(vertex).append(" ");
			
			for(int i=1; i<map[vertex].length; i++) {
				if(!visited[i] && map[vertex][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	private static void dfs(int v) {
		
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int i=1; i<map[v].length; i++) {
			if(!visited[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}

}
