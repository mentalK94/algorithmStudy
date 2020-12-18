/**
 * Backjoon - 3986. 좋은 단어
 * 좋은단어_3986.java
 * @date 2020-12-18
 * @author hansolKim
 **/

package p3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어_3986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			Stack<Character> st = new Stack<>();
			String word = br.readLine();
			for(int j=0; j<word.length(); j++) {
				char cur = word.charAt(j);
				if(!st.isEmpty() && cur == st.peek()) { // 같은 문자가 만난 경우
					st.pop();
					continue;
				}
				
				st.add(cur);
			}
			
			if(st.size() == 0) { answer++; } 
		}
		
		System.out.println(answer);
		br.close();
	}
}