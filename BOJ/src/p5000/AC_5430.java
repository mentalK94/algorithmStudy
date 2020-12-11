/**
 * Backjoon - 5430. AC
 * AC_5430.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC_5430 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			String p = br.readLine(); // 수행할 문자열 입력
			
			int N = Integer.parseInt(br.readLine()); // 숫자의 개수 입력
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			Deque<Integer> dq = new LinkedList<>();
			for(int i=0; i<N; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			int type = 0;
			boolean isError = false;
			for(int i=0; i<p.length(); i++) {
				char command = p.charAt(i);
				
				if(command == 'R') { // 배열 거꾸로 만들기 -> 타입 변경
					type = (type == 0) ? 1:0;
					continue;
				}
				
				// 삭제연산 구현
				// dq의 길이체크
				if(dq.isEmpty()) {
					isError = true;
					break;
				}
				
				if(type==0) {
					dq.pollFirst();
				} else {
					dq.pollLast();
				}
			}
			
			if(!isError) {
				sb.append("[");
				while(!dq.isEmpty()) {
					if(type == 0) { sb.append(dq.pollFirst()); }
					if(type == 1) { sb.append(dq.pollLast()); }
					sb.append(",");
					if(dq.isEmpty()) {
						sb.replace(sb.length()-1, sb.length(), "");
					}
				}
				sb.append("]");
			} else {
				sb.append("error");
			}
			
			sb.append("\n");
		}
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
