/**
 * Backjoon - 1629. 곱셈
 * 곱셈_1629.java
 * @date 2021-01-03
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_1629 {

	static int c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		long answer = getAnswer(a, b)%c;
		
		System.out.println(answer);
		br.close();
	}

	private static long getAnswer(long a, long b) {
		
		if(b == 0) return 1;
		if(b == 1) return a;
		if(b%2 == 1) return (getAnswer(a, b-1)*a)%c;
		long half = getAnswer(a, b/2);
		return (half*half)%c;
	}
	
	
}