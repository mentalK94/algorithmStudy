/**
 * Backjoon - 1753. 최단경로
 * ShortestRoute_1753.java
 * @date 2020-09-01
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	int dest;
	int weight;
	
	public Node(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}

public class ShortestRoute_1753 {
	
	private static final int INF = Integer.MAX_VALUE;
	private static int[] dist;
	private static boolean[] visited;
	private static List<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 정점의 개수(1... 20,000)
		int e = Integer.parseInt(st.nextToken()); // 간선의 개수(1... 300,000)
		
		int start = Integer.parseInt(br.readLine());
		dist = new int[v+1];
		visited = new boolean[v+1];
		
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Arrays.fill(dist, INF); // INF무한대로 초기화
		dijkstra(start);
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i] != INF) {
				sb.append(dist[i]);
			} else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.dest;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(int i=0; i<list[cur].size(); i++) {
				Node node = list[cur].get(i);
				if(dist[node.dest] > dist[cur] + node.weight) {
					dist[node.dest] = dist[cur] + node.weight;
					queue.add(new Node(node.dest, dist[node.dest])); // 인접정점을 큐에 삽입
				}
			}
		}
		
	}

}
