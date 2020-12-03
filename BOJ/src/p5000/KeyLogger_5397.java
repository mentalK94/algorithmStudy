/**
 * Backjoon - 5397. 키로거
 * KeyLogger_5397.java
 * @date 2020-12-03
 * @author hansolKim
 * */

package p5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class KeyLogger_5397 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			
			String logger = br.readLine();
			
			int cursor = 0;
			LinkedList<Character> pass = new LinkedList<>();
			for(int i=0; i<logger.length(); i++) {
				char ch = logger.charAt(i);
				
				if(ch == '<') {
					cursor--;
					if(cursor < 0) { cursor = 0;}
					continue;
				}
				
				if(ch == '>') {
					cursor++;
					if(cursor > pass.size()) { cursor = pass.size();}
					continue;
				}
				
				if(ch == '-') {
					cursor--;
					if(cursor<0) {cursor = 0; continue;}
					pass.remove(cursor);
					continue;
				}
				
				pass.add(cursor, ch);
				cursor++;
			}
			
			Iterator<Character> iter = pass.iterator();
			
			while(iter.hasNext()) {
				sb.append(iter.next());
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
