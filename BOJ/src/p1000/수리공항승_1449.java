/**
 * Backjoon - 1449. 수리공 항승
 * 수리공 항승_1449.java
 * @date 2021-02-26
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 수리공항승_1449 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; ++i) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.add(10000);
		
		Collections.sort(list);
		
		int pre = list.get(0);
		int answer = 0;
		for(int i=1; i<=N; ++i) {
			if(list.get(i)-pre>L-1) {
				answer++;
				pre = list.get(i);
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
