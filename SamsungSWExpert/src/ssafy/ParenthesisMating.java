/**
 * Samsung SW Expert - 1218. 괄호 짝짓기
 * ParenthesisMating.java
 * @date 2020-07-03
 * @author hansolKim
 **/

package ssafy;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisMating {

	private static Stack<Character> st;
	private static int size;
	private static StringBuilder stringBuilder;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		st = new Stack<>();
		stringBuilder = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			stringBuilder.append("#").append(test_case).append(" ");
			
			size = sc.nextInt(); // 문자열 길이
			
			String str = sc.next();
			
			for(int idx=0; idx<str.length(); idx++) {
				if(str.charAt(idx) == '(' || // 왼쪽인 경우 stack push
					str.charAt(idx) == '{' ||
					str.charAt(idx) == '[' ||
					str.charAt(idx) == '<') {

					st.push(str.charAt(idx));
					continue;
				}
				
				if(st.size() == 0) { // 유효하지 않은 경우
					st.push(str.charAt(idx));
					stringBuilder.append("0").append("\n");
					break;
				}
				
				if(str.charAt(idx) == ')' && st.peek() == '(') {
					st.pop();
					continue;
				}
				
				if(str.charAt(idx) == '>' && st.peek() == '<') {
					st.pop();
					continue;
				}
				
				if(str.charAt(idx) == '}' && st.peek() == '{') {
					st.pop();
					continue;
				}
				
				if(str.charAt(idx) == ']' && st.peek() == '[') {
					st.pop();
					continue;
				}
				
				stringBuilder.append("0").append("\n");
				break;
				
			}
			if(st.isEmpty()) {
				stringBuilder.append("1").append("\n");
			}
			st.clear();
			
		}
		
		System.out.println(stringBuilder.toString());
	}

}
