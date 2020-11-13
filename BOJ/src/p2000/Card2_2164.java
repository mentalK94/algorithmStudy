/**
 * Backjoon - 2164. 카드2
 * Card2_2164.java
 * @date 2020-11-13
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2_2164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) { q.add(i); }
		
		int x = 0;
		int order = 1;
		while(!q.isEmpty()) {
			if(q.size() == 1) { 
				System.out.println(q.poll());
				return;
			}
			// 1. 버린다
			x = q.poll();
			// 2. 뒤로 옮긴다
			if(order++%2==0) { q.add(x); }
			// 3. 한장인지 확인
		}
	}

}
