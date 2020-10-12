/**
 * Backjoon - 1233. 주사위
 * Dice_1233.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dice_1233 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[a+b+c+1];
		
		for(int i=1; i<=a; i++) {
			for(int j=1; j<=b; j++) {
				for(int k=1; k<=c; k++) {
					arr[i+j+k]++;
				}
			}
		}
		
		int idx = 0;
		int sum = 0;
		for(int i=1;i<arr.length; i++) {
			if(sum < arr[i]) {
				idx = i;
				sum = arr[i];
			}
		}
		
		System.out.println(idx);
		
	}

}
