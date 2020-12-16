/**
 * Backjoon - 1476. 날짜 계산
 * 날짜계산_1476.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산_1476 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int year = e;
		e = e==15 ? 0 : e;
		s = s==28 ? 0 : s;
		m = m==19 ? 0 : m;
		while(true) {
			if(year%15==e && year%28==s && year%19==m) { break; }
			year += 15;
		}
		
		System.out.println(year);
		br.close();
	}
}