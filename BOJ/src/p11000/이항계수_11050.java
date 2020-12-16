/**
 * Backjoon - 11050. 이항 계수 1
 * 이항계수_11050.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수_11050 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		K = K<N-K?K:N-K;
		int a = 1;
		int b = 1;
		int size = K;
		for(int i=0; i<size; i++) { a *= N--; }
		for(int i=0; i<size; i++) { b *= K--; }
		
		System.out.println(a/b);
		br.close();
	}
}