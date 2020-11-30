/**
 * Backjoon - 4949. 균형잡힌 세상
 * BalancedWorld_4949.java
 * @date 2020-11-30
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String str = null;
		
		Stack<Character> st = new Stack<>(); 
		while(true) {
			str = br.readLine();
			if(str.equals(".")) { break;}
			boolean isBalanced = true;
			
			str = str.replace(" ", "");
			str = str.replace(".", "");
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch >=65 && ch<=90) continue;
				if(ch >=97 && ch<=122) continue;
				if(ch == '(' || ch == '[') {
					st.add(ch);
					continue;
				}
				if(ch == ')') {
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					} else {
						isBalanced = false;
						break;
					}
				}
				if(ch == ']') {
					if(!st.isEmpty() && st.peek() == '[') {
						st.pop();
					} else {
						isBalanced = false;
						break;
					}
				}
			}
			
			if(st.size() != 0) { isBalanced = false; }
			
			if(isBalanced) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
			
			st.clear();
		}
		
		System.out.println(sb);
		br.close();
	}

}
