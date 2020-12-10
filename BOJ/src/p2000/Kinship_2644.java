/**
 * Backjoon - 2644. 촌수계산
 * Kinship_2644.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kinship_2644 {

	static int N, M, START, END;
	static LinkedList<Integer>[] chons;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		chons = new LinkedList[N+1];
		for(int i=1; i<=N; i++) {
			chons[i] = new LinkedList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chons[x].add(y);
			chons[y].add(x);
		}
	
		visited = new boolean[N+1];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {START, 0});
		
		int answer = -1;
		main:while(!q.isEmpty()) {
			int node = q.peek()[0];
			int chonCnt = q.poll()[1];
			
			// 해당 노드 방문처리
			visited[node] = true;
			
			// 해당 노드와 연결된 노드 찾기
			for(int i=0; i<chons[node].size(); i++) {
				int connectNode = chons[node].get(i); 
				// 이미 방문한 노드인 경우
				if(visited[connectNode]) { continue; }
				
				if(connectNode == END) { 
					answer = chonCnt+1;
					break main;
				}
				
				q.add(new int[] {connectNode, chonCnt+1});
			}
		}
		
		System.out.println(answer);
	}

}
