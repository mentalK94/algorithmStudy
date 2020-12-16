/**
 * Backjoon - 1037. 약수
 * 약수_1037.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약수_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
		
		Arrays.sort(arr);
			
		System.out.println(arr[0] * arr[arr.length-1]);
		br.close();
	}
}