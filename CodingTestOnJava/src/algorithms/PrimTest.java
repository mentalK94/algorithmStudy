package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimTest {

	static class Node implements Comparable<Node> {

		int from, to, weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E, minWeight;
	static ArrayList<Node>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[V + 1];

		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(from, to, weight));
			graph[to].add(new Node(to, from, weight));
		}
		
		minWeight = 0;

		prim(1);

		System.out.println(minWeight);

	}

	private static void prim(int start) {
		Queue<Integer> selectedNode = new LinkedList<>();
		PriorityQueue<Node> nodeList = new PriorityQueue<>();
		selectedNode.add(start);
		
		while(!selectedNode.isEmpty()) {
			
			int curNode = selectedNode.poll();
			visited[curNode] = true; // 정점 방문 표기
			
			for(Node node : graph[curNode]) {
				if(!visited[node.to]) { // 방문하지 않은 노드인 경우
					nodeList.add(node);
				}
			}
			
			while(!nodeList.isEmpty()) {
				Node node = nodeList.poll();
				if(!visited[node.to]) {
					selectedNode.add(node.to);
					visited[node.to] = true;
					minWeight+=node.weight;
					System.out.println(minWeight);
					break;
				}
			}
		}
		
		
	}
}
