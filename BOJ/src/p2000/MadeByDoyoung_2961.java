/**
 * Backjoon - 2961. 도영이가 만든 맛있는 음식
 * MadeByDoyoung.java
 * @date 2020-08-06
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MadeByDoyoung_2961 {

	private static int N; // 재료 갯수
	private static int R; // 재료 선택 갯수
	private static int[] s; // 신맛
	private static int[] b; // 쓴맛
	private static int[] selectedS; // 신맛
	private static int[] selectedB; // 쓴맛
	private static int diff;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		b = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		diff = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) { // 재료를 1개부터 N개 까지 고르는 경우의 수
			R = i; // 재료 선택 개수
			selectedS = new int[R];
			selectedB = new int[R];
			combination(0, 0);
		}
		
		System.out.println(diff);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			int sumS = 1; // 신맛은 곱
			int sumB = 0;
			
			for(int i=0; i<R; i++) {
				sumS *= selectedS[i];
				sumB += selectedB[i];
			}
			int tempDiff = Math.abs(sumB-sumS);
			diff = Math.min(diff, tempDiff);
			return;
		}
		
		for(int i=start; i<N; i++) {
			selectedS[cnt] = s[i];
			selectedB[cnt] = b[i];
			combination(cnt+1, i+1);
		}
	}

}
