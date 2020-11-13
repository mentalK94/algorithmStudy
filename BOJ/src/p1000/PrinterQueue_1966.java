/**
 * Backjoon - 1966. 프린터 큐
 * PrinterQueue_1966.java
 * @date 2020-11-13
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue_1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 인덱스
			
			ArrayList<Integer> orderList = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int o = Integer.parseInt(st.nextToken());
				orderList.add(o);
				q.add(new int[] {i, o});
			}
			
			Collections.sort(orderList, Collections.reverseOrder());
				
			int order = 1;
			int orderIdx = 0;
			while(!q.isEmpty()) {
				int[] print = q.poll();
				if(print[1] == orderList.get(orderIdx)) {
					if(print[0] == M) { break;}
					orderIdx++;
					order++;
				} else {
					q.add(new int[] {print[0], print[1]});
				}				
			}
			
			sb.append(order).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
