/**
 * Backjoon - 2609. 최대공약수와 최소공배수
 * GcdAndLcm_2609.java
 * @date 2020-09-28
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GcdAndLcm_2609 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int max = n > m ? n : m;
		int min = n < m ? n : m;
		
		int lcm = 0;
		int gcd = 0;
		
		// 최대 공약수 구하기
		gcd = getGCD(max, min);
		
		// 최소 공배수 구하기
		lcm = getLCM(max, min);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int getLCM(int max, int min) {
		int idx = 1;
		while(true) {
			if((max*idx)%min == 0) {
				return max*idx;
			}
			idx++;
		}
	}

	private static int getGCD(int x, int y) {
		while(y!=0) {
			int r = x%y;
			x = y;
			y = r;
		}
		return x;
	}

}
