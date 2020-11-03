package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		int start = 1; 
		int end = v;
		
		int[][] matrix = new int[v+1][v+1];
		int[] distance = new int[v+1];
		boolean[] visited = new boolean[v+1];
		
		for (int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=v; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		int min = 0, current=0;
		
		for(int i=1; i<=v; i++) {
			
			min = INF;
			// 1단계 : 방문하지 않은 정점들 중에 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			for(int j=1; j<=v; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(current == end) break;
			
			// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			for (int j = 1; j <= v; j++) {
				// min ==> distance[current]
				if(!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]) {
					distance[j] = min + matrix[current][j]; // 더 짧은거리 갱신
				}
			}
			
		}
		
		System.out.println(distance[end]);
	}
}
