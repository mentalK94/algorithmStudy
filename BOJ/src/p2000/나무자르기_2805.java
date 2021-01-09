/**
 * Backjoon - 2805. 나무 자르기
 * 나무자르기_2805.java
 * @date 2021-01-07
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
	
	static int[] trees;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 나무의 개수
		int m = Integer.parseInt(st.nextToken()); // 가져가기위한 나무크기
		
		trees = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		

		Arrays.sort(trees);
		System.out.println(binarySearch(0, trees[trees.length-1], m));
		br.close();
	}

	private static int binarySearch(int start, int end, int dest) {
		while(start <= end) {
			int mid = (start+end) / 2;
			
			long sum = 0;
			for(int v : trees) {			
				sum += v-mid>0 ? v-mid : 0;
			}
			
			if(sum>=dest) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return end;
	}
}