/**
 * Backjoon - 1075. 나누기
 * Divide_1075.java
 * @date 2020-10-09
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Divide_1075 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		N /= 100;
		N *= 100;
				
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<100; i++) {
			if(N%F == 0) {
				if(i<10) {
					sb.append(0);
				}
				sb.append(i);
				break;
			}
			N++;
		}
		
		System.out.println(sb);
	}

}
