/**
 * Backjoon - 2257. 화학식량
 * 화학식량_2257.java
 * @date 2020-12-30
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 화학식량_2257 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String chem = br.readLine();

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < chem.length(); i++) {
			char ch = chem.charAt(i);

			switch (ch) {
			case 'H': // 수소
				st.add(1);
				break;
			case 'C': // 탄소
				st.add(12);
				break;
			case 'O': // 산소
				st.add(16);
				break;
			case '(': // 여는괄호
				st.add(-1);
				break;
			case ')': // 닫는괄호
				int inner = 0;
				while(st.peek() != -1) { // 여는괄호가 나올때까지 모두 더함
					inner += st.pop();
				}
				st.pop(); // 여는괄호 꺼내기
				st.add(inner); // 다시 삽입
				break;
			default: // 숫자
				int top = st.pop();
				top *= (ch-'0');
				st.add(top);
				break;
			}
		}
		
		int answer = 0;
		while(!st.isEmpty()) {
			answer += st.pop();
		}

		System.out.println(answer);
		br.close();

	}
}