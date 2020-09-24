/**
 * Backjoon - 10158. 개미
 * Ant_10158.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ant_10158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());
		
		int x=0, y=0;
		
		if(((p+t)/w)%2==0) { // 짝수(증가)
			x = (p+t)%w;
		} else { // 홀수(감소)
			x = w-(p+t)%w; 
		}
		
		if(((q+t)/h)%2==0) { // 짝수(증가)
			y = (q+t)%h;
		} else { // 홀수(감소)
			y = h-(q+t)%h; 
		}
		
		System.out.println(x + " " + y);
		
		br.close();
	}
}
