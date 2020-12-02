/**
 * Backjoon - 2504. 괄호의 값
 * BracketValue_2504.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketValue_2504 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int answer = 0;
		int	temp = 1;
		Stack<Character> st = new Stack<>();
		
		boolean isRight = true;
		boolean isCalc = false;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch=='(' || ch=='[') {
				st.add(ch);
				if(ch=='(') { temp *= 2; }
				if(ch=='[') { temp *= 3; }
				isCalc = false;
				continue;
			}
			
			
			if(!isCalc) {
				isCalc = true;
				answer += temp;
			}
			
			if(ch==')' && !st.isEmpty() && st.peek() == '(') { // 닫는 중괄호
				st.pop();				
				// answer += temp;
				temp /= 2;
			} else if(ch==']' && !st.isEmpty() && st.peek() == '[') { // 닫는 중괄호
				st.pop();
				// answer += temp;
				temp /= 3;
			} else {
				isRight = false;
				break;
			}
		}
		
		if(isRight && st.size() == 0) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}
		
		br.close();
	}

}
