/**
 * Backjoon - 1543. 문서 검색
 * 문서검색_1543.java
 * @date 2020-12-20
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문서검색_1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String doc = br.readLine();
		String search = br.readLine();
		
		int cnt = 0;
		for(int i=0; i<doc.length()-search.length()+1; i++) {
			if(doc.substring(i, i+search.length()).equals(search)) {
				cnt++;
				i+=(search.length()-1);
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}