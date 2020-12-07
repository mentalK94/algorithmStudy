/**
 * Backjoon - 1005. ACM Craft
 * ACMCraft_1005.java
 * @date 2020-12-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft_1005 {
	
	static int N, K, W, TIME; // 건물의 개수, 규칙의 개수, 목적건물
	static boolean[] visited; // 방문체크 배열
	static int[] buildTimes, inDegree, times; // 건설시간 배열, 진입차수 배열, 각 건물을 짓는데 걸리는 최소시간
	static LinkedList[] techTree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			buildTimes = new int[N+1];
			inDegree = new int[N+1];
			techTree = new LinkedList[N+1];
			times = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				techTree[i] = new LinkedList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				buildTimes[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				techTree[x].add(y);
				inDegree[y]++;
			}
			
			W = Integer.parseInt(br.readLine()); // 목적건물 입력
			
			build();
			sb.append(times[W]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void build() {
		Queue<Integer> q = new LinkedList<>();
		
		// 진입차수가 0인 것 넣기
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) { // 진입차수가 0인 것 큐에 넣기
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int building = q.poll();
			times[building] += buildTimes[building];
			visited[building] = true;
			if(building == W) { // 목적건물을 찾은 경우
				return;
			}
			
			for(int i=0; i<techTree[building].size(); i++) { // 이어진 정점 연결
				int connectBuild = (int) techTree[building].get(i); // 연결된 빌딩
				if(visited[connectBuild]) continue;
				times[connectBuild] = Math.max(times[connectBuild], times[building]); // 이전 빌드타임 중 가장 오래걸리는 것을 배열에 넣음
				if(--inDegree[connectBuild] == 0) {
					q.offer(connectBuild);
				}
			}
			
		}
	}

}
