/**
 * Backjoon - 5567. 결혼식
 * Wedding_5567.java
 * @date 2020-09-17
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wedding_5567 {

	private static int N, M;
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	private static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		answer = 0;
		bfs(1);
		System.out.println(answer);
	}

	private static void bfs(int start) {
		// start점 큐에 넣고 방문처리
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();

		// 친구들 검색
		for (int i = 0; i < list[start].size(); i++) {
			visited[list[start].get(i)] = true;
			q.add(list[start].get(i));
			answer++;
		}
		// 친구의 친구 검색
		while(!q.isEmpty()) {
			int number = q.poll();
			for(int i=0; i<list[number].size(); i++) {
				if(!visited[list[number].get(i)]) {
					answer++;
					visited[list[number].get(i)] = true;
				}
			}
		}

	}

}
