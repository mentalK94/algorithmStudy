/**
 * Backjoon - 2304. 창고 다각형
 * WarehousePolygon_2304.java
 * @date 2020-09-22
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WarehousePolygon_2304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] pole = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			pole[i][0] = Integer.parseInt(st.nextToken());
			pole[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int maxHeight = 0;
		int maxIdx = 0;
		int maxCnt = 0;
		
		for(int i=0; i<N; i++) {
			if(maxHeight < pole[i][1]) {
				maxHeight = pole[i][1];
				maxCnt = 1;
				maxIdx = i;
			} else if(maxHeight == pole[i][1]) {
				maxCnt++;
			}
		}
		
		// 기둥의 위치를 기준으로 오름차순 정렬
		Arrays.sort(pole, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});
		
		int area = 0; // 총 면적
		int curIdx = 0; // 현재 위치		
		
		for(int i=0; i<N; i++) {
			
			// 1. 현재 기둥의 높이 조사
			int height = pole[i][1];
			
			
		}
		
	}

}
