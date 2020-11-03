/**
 * Backjoon - 2477. 참외밭
 * MelonField_2477.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MelonField_2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int maxW=0, maxH=0;
		int[] values = new int[6];
		int[] dirs = new int[6];
		int[] reverseTime = {4,2,3,1};
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(dir == 1 || dir == 2) { // 동쪽 또는 서쪽
				if(value > maxH) {
					maxH = value;
				}
			} else { // 북쪽 또는 남쪽
				if(value > maxW) {
					maxW = value;
				}
			}
			dirs[i] = dir;
			values[i] = value;
		}
		
		int idx;
		
		for(idx=0; idx<4; idx++) {
			if(reverseTime[idx] == dirs[0]) break;
		}
		
		boolean isflag = false;
		for(int i=1; i<6; i++) {
			if(dirs[i] != reverseTime[++idx%4]) { // 시계방향으로 된 경우
				isflag = true;
				break;
			}
		}
		
		if(!isflag) {
			idx = 1;
		}
		
		System.out.println((maxH*maxW-values[idx]*values[idx-1])*N);
		
	}

}
