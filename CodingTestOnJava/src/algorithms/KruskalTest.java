package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

	static class Edge implements Comparable<Edge>{
		
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static Edge[] edges;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new Edge[E];
		parents = new int[V+1];
		
		int from, to, weight;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edges);
		
		make();
		
		int select = 0;
		int minWeight = 0;
		
		for(int i=0; i<edges.length; i++) {
			if(select == V-1) { break;}
			if(union(edges[i].from, edges[i].to)) {
				minWeight+=edges[i].weight;
				select++;
			}
		}
		
		System.out.println(minWeight);
		
	}
	
	private static void make() {
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}
}
