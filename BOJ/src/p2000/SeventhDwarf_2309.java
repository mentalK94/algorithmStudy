/**
 * Backjoon - 2309. 일곱 난쟁이
 * SeventhDwarf_2309.java
 * @date 2020-09-19 
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeventhDwarf_2309 {

	private static int N, R;
	private static int[] input, selected;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 9; R = 7;
		input = new int[N];
		selected = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
	}

	private static void combination(int start, int cnt) {
		if(cnt == R) {
			int sum = 0;
			for(int i=0; i<R; i++) {
				sum+=selected[i];
			}
			if(sum == 100) {
				Arrays.sort(selected);
				for(int i=0; i<selected.length; i++) {
					System.out.println(selected[i]+" ");
				}
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}	

}
