package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> heightMemory = new Stack<>();
		Stack<Integer> indexMemory = new Stack<>();
		int N = Integer.parseInt(br.readLine()); // 탑의 수
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		
		
		for (int idx=0; idx < N ; idx++) {
			
			int height = Integer.parseInt(st.nextToken()); // 탑 높이 입력
			
			// 현재 탑의 높이가 이전 탑의 높이보다 클 때까지 스택에서 값을 꺼낸다.
			while(true) {
				
				// 모두 꺼내어 진 경우
				if(heightMemory.isEmpty()) {
					sb.append("0 ");
					heightMemory.push(height);
					indexMemory.push(idx+1);
					break;
				} 
				
				// 수신 받은 경우
				if(height < heightMemory.peek()) {
					sb.append(indexMemory.peek() + " "); // 수신받은 인덱스 위치 값
					heightMemory.push(height);
					indexMemory.push(idx+1);
					break;
				}
				
				// 수신 받지 못한경우
				heightMemory.pop();
				indexMemory.pop();
			}	
		}

		System.out.print(sb.toString());
	}
}
