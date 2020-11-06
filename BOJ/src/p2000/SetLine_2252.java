/**
 * Backjoon - 2252. 줄 세우기
 * SetLine_2252.java
 * @date 2020-11-04
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SetLine_2252 {

	static int N, M;
	static int[] inDegreeCnt;
	static ArrayList[] list;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		inDegreeCnt = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegreeCnt[b]++;
		}
		
		sb = new StringBuilder();
		topology();
		System.out.println(sb);
		br.close();
	}

	private static void topology() {
		Queue<Integer> q = new LinkedList<>();
		
		// 진입차수가 0인 정점 큐에 삽입
		for(int i=1; i<=N; i++) {
			if(inDegreeCnt[i] == 0) {
				q.add(i);
			}
		}
		
		// 위상정렬이 완전히 수행되려면 정확히 N개 노드 방문
		for(int i=1; i<=N; i++) {
			int curNode = q.poll();
			sb.append(curNode).append(" ");
			
			for(int j=0; j<list[curNode].size(); j++) {
				int connectNode = (int) list[curNode].get(j);
				if(--inDegreeCnt[connectNode] == 0) {
					q.add(connectNode);
				}
			}
		}
	}

}
