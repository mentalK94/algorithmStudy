/**
 * Backjoon - 1343. 폴리오미노
 * Polyomino_1343.java
 * @date 2020-12-07
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Polyomino_1343 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		Queue<Character> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		boolean isFail = false;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '.') {
				if(q.size() > 0 ) {
					if(q.size() == 2) { 
						sb.append("BB");
						q.clear();
					}
					else { isFail = true; break;}
				}
				sb.append('.');
			}
			if(ch == 'X') {
				q.add('X');
				if(q.size() == 4) {
					sb.append("AAAA");
					q.clear();
				}
			}
		}
		
		if(q.size() > 0) {
			if(q.size() == 2) { 
				sb.append("BB");
				q.clear();
			}
			else { isFail = true; }
		}
		
		if(isFail) {
			bw.write("-1");
		} else {
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
