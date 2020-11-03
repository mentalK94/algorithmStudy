/**
 * Backjoon - 2304. 창고 다각형
 * WarehousePolygon_2304.java
 * @date 2020-10-27
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WarehousePolygon_2304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[1001];
		int left = 1000;
		int right = 1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int x = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			map[x] = height;
			if(x < left) { left = x;}
			if(x > right) { right = x;}
		}
		
		// 왼쪽, 오른쪽에서 시작해서 면적 저장
		int[] leftMap = new int[right+1];
		int[] rightMap = new int[right+2];
		
		// 왼쪽에서 시작한 면적 구하기
		for(int i=left; i<=right; i++) {
			// 이전 영역보다 크면 영역의 크기 변경
			leftMap[i] = Math.max(leftMap[i-1], map[i]);
		}
		
		// 오른쪽에서 시작한 면적 구하기
		for(int i=right; i>=left; i--) {
			rightMap[i] = Math.max(rightMap[i+1], map[i]);
		}
		
		int answer = 0;
		for(int i=left; i<=right; i++) {
			answer += Math.min(leftMap[i], rightMap[i]);
		}
		
		System.out.println(answer);
	}

}
