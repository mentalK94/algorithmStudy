/**
 * Backjoon - 6549. 히스토그램에서 가장 큰 직사각형
 * 히스토그램에서가장큰직사각형_6549.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램에서가장큰직사각형_6549 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) { break; }
			
			int[] height = new int[N+2];
			for(int i=1; i<=N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			height[N+1] = 0;
			
			Stack<Integer> stack = new Stack<>();
			
			stack.add(0);
			
			long answer = 0;
			for(int i=1; i<=N+1; i++) {
				while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
					long h = height[stack.peek()];
					stack.pop();
					int w = i-stack.peek()-1; 
									
					answer = Math.max(answer, h*w);
				}
				
				stack.add(i);
			}
			
			sb.append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
