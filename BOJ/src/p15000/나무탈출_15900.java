/**
 * Backjoon - 15900. 나무 탈출
 * 나무탈출_15900.java
 * @date 2021-01-05
 * @author hansolKim
 **/

package p15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무탈출_15900 {

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) { nodes[i] = new ArrayList<>(); }
		
		while(N-->1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		visited[1] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int curNode = q.peek()[0]; // 현재노드
			int level = q.poll()[1];
			
			boolean isLeaf = true;
			for(int connectedNode : nodes[curNode]) {
				if(visited[connectedNode]) { continue; } // 이미 방문한 경우
				isLeaf = false; // 리프노드가 아님을 표기
				visited[connectedNode] = true; // 방문 표기
				q.add(new int[] {connectedNode, level+1});
			}
			
			if(isLeaf) { // 리프노드인 경우
				cnt+=level;
			}
		}
		
		System.out.println(cnt%2==1 ? "Yes" : "No");
		br.close();
	}
}