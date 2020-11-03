package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FloydWarshallTest {
	
	static final int INF = 1000000000;

	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == -1) {map[i][j] = INF;}
			}
		}
		
		for(int i=1; i<=N; i++) { // 거쳐가는 노드
			for(int j=1; j<=N; j++) { // 출발노드
				for (int k=1; k<=N; k++) { // 도착노드
					if(map[j][i] + map[i][k] < map[j][k]) {
						map[j][k] = map[j][i] + map[i][k]; 
					}
				}				
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
