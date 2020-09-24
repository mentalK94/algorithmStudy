/**
 * Backjoon - 2628. 종이자르기
 * CuttingPaper_2628.java
 * @date 2020-09-24
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CuttingPaper_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> xList = new ArrayList<>();
		ArrayList<Integer> yList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		yList.add(Integer.parseInt(st.nextToken()));
		xList.add(Integer.parseInt(st.nextToken()));
		xList.add(0); yList.add(0);

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int number = Integer.parseInt(st.nextToken()); // 자르는 번호
			
			if(dir==0) { xList.add(number); } // 가로 
			else { yList.add(number); } // 세로
		}
		
		// 오름차순 정렬
		Collections.sort(xList);
		Collections.sort(yList);
		
		int maxArea = 0;
		// 넓이 구하기
		for(int i=0; i<xList.size()-1; i++) {
			for(int j=0; j<yList.size()-1; j++) {
				int area = ((xList.get(i+1)-xList.get(i))*(yList.get(j+1)-yList.get(j)));
				
				if(maxArea < area) { maxArea = area; }
			}
		}
		
		System.out.println(maxArea);
	}

}
