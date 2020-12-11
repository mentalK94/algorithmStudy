/**
 * Backjoon - 5430. AC
 * AC_5430.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsoluteHeap_11286 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) { // 절대값 꺼내기
				if(!pq.isEmpty()) {
					sb.append(pq.peek()[0]*pq.poll()[1]);
				} else {
					sb.append(0);
				}
				sb.append("\n");
				continue;
			} 
			
			if(x>0) { pq.add(new int[] {x, 1}); }
			if(x<0) { pq.add(new int[] {-x, -1}); }
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
