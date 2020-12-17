/**
 * Backjoon - 18258. 큐 2
 * 큐2_18258.java
 * @date 2020-12-17
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2_18258 {
	
	static Deque<Integer> queue;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			switch (command) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				queue.add(value);
				continue;
			case "front":
				if(queue.size() != 0) {
					sb.append(queue.peekFirst());
				} else {
					sb.append("-1");
				}
				break;
			case "back":
				if(queue.size() != 0) {
					sb.append(queue.peekLast());
				} else {
					sb.append("-1");
				}
				break;
			case "size":
				sb.append(queue.size());
				break;
			case "empty":
				if(queue.size() == 0) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				break;
			case "pop":
				if(queue.size() != 0) {
					sb.append(queue.pollFirst());
				} else {
					sb.append("-1");
				}
				break;
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}