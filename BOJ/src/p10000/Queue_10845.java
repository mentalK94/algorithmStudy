/**
 * Backjoon - 10845. 큐
 * Queue_10845.java
 * @date 2020-11-12
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Queue_10845 {

	static ArrayList<Integer> st;
	static int pointer;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());

		st = new ArrayList<>();
		sb = new StringBuilder();
		pointer = -1;

		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				push(X);
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void back() {
		if(pointer == -1) {
			sb.append(-1);
		} else { sb.append(st.get(pointer));}
		sb.append("\n");
	}

	private static void front() {
		if(pointer == -1) {
			sb.append(-1);
		} else { sb.append(st.get(0));}
		sb.append("\n");
	}

	private static void empty() {
		if(pointer == -1) {
			sb.append(1);
		} else { sb.append(0);}
		sb.append("\n");
	}

	private static void size() {
		sb.append(pointer+1).append("\n");
	}

	private static void pop() {
		if(pointer == -1) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(st.get(0)).append("\n");
		st.remove(0);
		pointer--;
	}

	private static void push(int x) {
		st.add(x);
		pointer++;
	}

}
