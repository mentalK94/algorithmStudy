/**
 * Backjoon - 10773. 제로
 * Zero_10773.java
 * @date 2020-11-11
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>(); 
		
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				st.pop();
			} else {
				st.add(num);
			}
		}
		
		int answer = 0;
		while(!st.isEmpty()) {
			answer += st.pop();
		}
		
		System.out.println(answer);
	}

}
