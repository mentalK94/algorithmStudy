/**
 * Backjoon - 1924. 2007년
 * TwoThousandSeven_1924.java
 * @date 2020-10-09
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoThousandSeven_1924 {

	public static void main(String[] args) throws Exception{
		String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int d = 0;
		for(int i=0; i<x; i++) {
			d += month[i];
		}
		d += y;
		d %= 7;
		System.out.println(day[d]);
	}

}
