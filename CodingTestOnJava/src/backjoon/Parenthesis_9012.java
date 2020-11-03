/**
 * Backjoon - 9012. 괄호
 * Parenthesis_9012.java
 * @date 2020-11-03
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis_9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(isRight(str)) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static boolean isRight(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {

			if(str.charAt(i) == '(') { // '('이면 스택에 쌓기
				st.add('(');
			} else { // ')'이면 스택에서 '(' 팝
				if(st.size() == 0) { // 뺄 괄호가 없다면
					return false;
				} else {
					st.pop();
				}
			}

		}
		
		if(st.size() == 0) {return true;}
		return false;
	}

}
