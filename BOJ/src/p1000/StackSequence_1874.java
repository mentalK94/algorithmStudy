/**
 * Backjoon - 1874. 스택 수열
 * StackSequence_1874.java
 * @date 2020-11-13
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class StackSequence_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		int num = 0;
		boolean isSuccess = true;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			int targetNumber = Integer.parseInt(br.readLine());
			
			// 1. num이 targetNumber보다 작다면 아직 들어가지 않았기 때문에
			// num == targetNumber가 될 때까지 삽입
			while(num < targetNumber) {
				st.add(++num);
				sb.append("+").append("\n");
			}
			
			// 2. 스택에서 꺼내서 targetNumber와 비교 --> 같지 않다면 의미없이 버려지므로 NO
			int number = st.pop();
			if(number == targetNumber) {
				sb.append("-").append("\n");
			} else {
				isSuccess = false;
			}
		}
		
		if(isSuccess) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
		br.close();
	}

}
