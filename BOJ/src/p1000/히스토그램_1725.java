/**
 * Backjoon - 1919. 애너그램 만들기
 * 애너그램만들기_1919.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 히스토그램_1725 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] height = new int[N+2];
		for(int i=1; i<=N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		height[N+1] = 0;
		
		Stack<Integer> st = new Stack<>();
		
		st.add(0);
		
		int answer = 0;
		for(int i=1; i<=N+1; i++) {
			while(!st.isEmpty() && height[st.peek()] > height[i]) {
				int h = height[st.peek()];
				st.pop();
				int w = i-st.peek()-1; 
			
				answer = Math.max(answer, h*w);
			}
			
			st.add(i);
		}
		
		System.out.println(answer);
		br.close();
	}
}