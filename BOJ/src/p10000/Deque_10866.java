/**
 * Backjoon - 10866. 덱
 * Deque_10866.java
 * @date 2020-11-14
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Deque_10866 {

	static ArrayList<Integer> deque;
	static int pointer;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());

		deque = new ArrayList<>();
		sb = new StringBuilder();
		pointer = -1;

		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push_front":
				int x1 = Integer.parseInt(st.nextToken());
				pushFront(x1);
				break;
			case "push_back":
				int x2 = Integer.parseInt(st.nextToken());
				pushBack(x2);
				break;				
			case "pop_front":
				popFront();
				break;
			case "pop_back":
				popBack();
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
		} else { sb.append(deque.get(pointer));}
		sb.append("\n");
	}

	private static void front() {
		if(pointer == -1) {
			sb.append(-1);
		} else { sb.append(deque.get(0));}
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

	private static void popFront() {
		if(pointer == -1) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(deque.get(0)).append("\n");
		deque.remove(0);
		pointer--;
	}
	
	private static void popBack() {
		if(pointer == -1) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(deque.get(pointer)).append("\n");
		deque.remove(pointer--);
	}

	private static void pushFront(int x) {
		deque.add(0, x);
		pointer++;
	}
	
	private static void pushBack(int x) {
		deque.add(x);
		pointer++;
	}
}
