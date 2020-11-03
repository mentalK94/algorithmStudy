/**
 * Backjoon - 3009. 네번째 점
 * FourthPoint_3009.java
 * @date 2020-08-23
 * @author hansolKim
 **/

package p3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourthPoint_3009 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] x = new int[3];
		int[] y = new int[3];
		int xSum = 0, ySum = 0;

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			xSum+=x[i];
			ySum+=y[i];
		}

		Arrays.sort(x);
		Arrays.sort(y);

		for (int i = 0; i < 2; i++) {
			if (x[i] == x[i+1]) {
				xSum -= (x[i]*2);
				sb.append(xSum + " ");
				break;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			if (y[i] == y[i+1]) {
				ySum -= (y[i]*2);
				sb.append(ySum);
				break;
			}
		}

		System.out.println(sb.toString());
	}

}
