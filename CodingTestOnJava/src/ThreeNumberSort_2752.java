/**
 * Backjoon - 2752. 세 수 정렬
 * ThreeNumberSort_2752.java
 * @date 2020-10-09
 * @author hansolKim
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeNumberSort_2752 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for(int i=0; i<3; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}
