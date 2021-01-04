/**
 * Backjoon - 1991. 트리 순회
 * 트리순회_1991.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
	
	static LinkedList<Integer>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int N = Integer.parseInt(br.readLine());
		
		tree = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i] = new LinkedList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		int start = 1;
		q.add(start);
		visited[start] = true;
		
		int[] parents = new int[N+1];
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int i=0; i<tree[node].size(); i++) {
				int childNode = tree[node].get(i);
				if(visited[childNode]) { continue; }
				parents[childNode] = node;
				visited[childNode] = true;
				q.add(childNode);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<=N; i++) {
			sb.append(parents[i]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}