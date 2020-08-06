/**
 * Backjoon - 2108. 통계학
 * Statistics_2108.java
 * @date 2020-08-07
 * @author hansolKim
 **/

package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Statistics_2108 {

	private static int[] pfrequency = new int[4001]; // 양수
	private static int[] nfrequency = new int[4001]; // 음수
	private static int MAX = Integer.MIN_VALUE;
	private static int MIN = Integer.MAX_VALUE;
	private static int CENTER = 0;
	private static int SUM = 0;
	private static float AVG = 0;
	private static int frequency;
	private static int MAX_Frequency;
	private static int cnt = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			list.add(num);						
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			SUM += num;
			if(num >= 0) {
				pfrequency[num]++;
			} else {
				nfrequency[Math.abs(num)]++;
			}
		}
		
		int[] temp = nfrequency.clone();
		Arrays.sort(temp);
		frequency = temp[4000];
		temp = pfrequency.clone();
		Arrays.sort(temp);
		frequency = Math.max(frequency, temp[4000]);
		
		for(int i=4000; i>0; i--) {
			if(cnt == 2) {break;}
			if(nfrequency[i] == frequency) {
				MAX_Frequency = i*(-1);
				cnt++;
			}
		}
		
		if(cnt != 2) {
			for(int i=0; i<=4000; i++) {
				if(cnt == 2) {break;}
				if(pfrequency[i] == frequency) {
					MAX_Frequency = i;
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		
		AVG = (float)SUM/(float)N;
		if(AVG >= 0)
			AVG = Math.round(AVG);
		else {
			AVG -= 0.5;
			AVG = (float) Math.ceil(AVG);
		} 
			
		CENTER = list.get(N/2);
		System.out.println((int) AVG);
		System.out.println(CENTER);
		System.out.println(MAX_Frequency);
		System.out.println(MAX-MIN);
	}

}
