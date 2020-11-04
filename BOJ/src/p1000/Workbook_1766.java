/**
 * Backjoon - 1766. 문제집
 * Workbook_1766.java
 * @date 2020-11-05
 * @author hansolKim
 **/


package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Workbook_1766 {

	static int N, M;
	static int[] inDegree;
	static ArrayList[] list;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>(); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		
		sb = new StringBuilder();
		topology();
		System.out.println(sb);
		br.close();
	}

	private static void topology() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 진입차수가 0인 것  pq삽입
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) {pq.add(i);}
		}
		
		// 모든 정점 수만큼 탐색
		for(int i=1; i<=N; i++) {
			int curProblem = pq.poll();
			sb.append(curProblem).append(" ");
			
			for(int j=0; j<list[curProblem].size(); j++) {
				int relateProblem = (int) list[curProblem].get(j);
				if(--inDegree[relateProblem] == 0) {
					pq.add(relateProblem);
				}
			}
		}
	}

}
