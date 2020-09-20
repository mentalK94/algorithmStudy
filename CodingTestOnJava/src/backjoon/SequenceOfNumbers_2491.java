/**
 * Backjoon - 2491. 수열
 * SequenceOfNumbers_2491.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceOfNumbers_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int connection = 1;
		int maxConnection = 0;
		int dir = 0; // 0인 경우 무방향, 1: 연속적으로 증가, 2: 연속적으로 감소
		for(int i=1; i<N; i++) {
			System.out.println(connection + " " + dir);
			int curNum = Integer.parseInt(st.nextToken());
			if(num == curNum) { // 같은 숫자가 들어오는 경우
				connection++;
				continue;
			}
			
			if(dir == 0) {
				connection++;				
				if(num < curNum) {dir = 1;}
				else { dir = 2;}
				num = curNum;
				continue;
			}
			
			// 연속해서 커지는 상황에서 더 커진 경우거나 연속해서 작아지는 상황에서 더 작아진 경우
			if((dir==1 && num < curNum) || (dir==2 && num > curNum)) { 
				connection++;
				num = curNum;
			} else {
				maxConnection = Math.max(maxConnection, connection);
				connection = 2;
				if(num < curNum) { // 연속 작아지는 상황에서 커진 경우
					dir = 1;
				} else {
					dir = 2;
				}
				num = curNum;
			}
			
		}
		
		System.out.println(maxConnection);
	}

}
