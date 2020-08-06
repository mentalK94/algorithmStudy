/**
 * Samsung SW Expert
 * 최소 스패닝 트리
 * MST.java
 * @date 2020-08-06
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight; // weight 기준 오름차순
	}
}

public class MST {
	
	private static int V, E; // 정점의 개수, 간선의 개수 
	private static int[] parents;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#"+test_case+" ");
			
			StringTokenizer init = new StringTokenizer(br.readLine());
			ArrayList<Edge> edgeList = new ArrayList<>();
			
			V = Integer.parseInt(init.nextToken());
			E = Integer.parseInt(init.nextToken());
			
			for(int i=0; i<E; i++) {
				StringTokenizer info = new StringTokenizer(br.readLine());
				
				edgeList.add(new Edge(Integer.parseInt(info.nextToken()),
									  Integer.parseInt(info.nextToken()), 
									  Integer.parseInt(info.nextToken())));
			}
			
			parents = new int[V+1];
			
			makeSet();
			
			Collections.sort(edgeList); // 정렬
			
			// V-1(정점개수 - 1)만큼 간선 선택
			int select = 0;
			int idx = 0;
			long minWeight = 0;
			
			while(true) {
				if(select == V-1) { break;}
				
				if(union(edgeList.get(idx).start, edgeList.get(idx).end)) {
					select++;					
					minWeight += edgeList.get(idx).weight;
					System.out.println(minWeight);
				}
				idx++;
			}
			
			
			
			sb.append(minWeight+"\n");
		}
		
		System.out.println(sb);
	}

	private static void makeSet() {
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false; // cycle을 도는 경우
		parents[yRoot] = xRoot;
		return true;
	}

}
