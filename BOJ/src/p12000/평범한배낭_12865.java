/**
 * Backjoon - 12865. 평범한 배낭
 * 평범한배낭_12865.java
 * @date 2021-01-27
 * @author hansolKim
 **/

package p12000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int size = list.size();
			
			for(int j=0; j<size; j++) {
				int curW = list.get(j)[0];
				int curV = list.get(j)[1];
				
				if(w+curW<=K) {
					list.add(new int[] {w+curW, v+curV});
				}
			}
			
			if(w<=K) {
				list.add(new int[] {w, v});
			}
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		
		});
		System.out.println(list.get(0)[1]);
		br.close();
	}
}