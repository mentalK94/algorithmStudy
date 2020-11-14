/**
 * Backjoon - 1406. 에디터
 * Editor_1406.java
 * @date 2020-11-14
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Editor_1406 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();
		
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		int cmdCnt = Integer.parseInt(br.readLine());
		//int cursor = str.length();
		int size = str.length();
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}

		for (int i = 0; i < cmdCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "L":
				if(iter.previousIndex()>=0) { iter.previous();}
				break;
			case "D":
				if(iter.nextIndex()<size) { iter.next();}
				break;
			case "B":
				if(iter.previousIndex()>=0) {
					iter.previous();
					iter.remove();
					size--;
				}
				break;
			case "P":
				char ch = st.nextToken().charAt(0);
				iter.add(ch);
				size++;
				break;
			}
		}
		
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.println(sb);
		br.close();
	}
}