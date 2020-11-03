/**
 * Backjoon - 1244. 스위치 켜고 끄기
 * SwitchOnOff_1244.java
 * @date 2020-09-23
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int switchCnt = Integer.parseInt(br.readLine());
		int[] switches = new int[switchCnt+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=switchCnt; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력
		int stuCnt = Integer.parseInt(br.readLine());
		
		// 학생 정보배열
		int[][] students = new int[stuCnt][2];
		
		// 학생 정보담기
		for(int i=0; i<stuCnt; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 한명씩 꺼내서 수행
		for(int i=0; i<stuCnt; i++) {
			if(students[i][0] == 1) { // 남자인 경우
				for(int j=students[i][1]; j<=switchCnt; j++) {
					if(j%students[i][1] == 0) { // 배수의 경우 ---> 스위치 변경
						switches[j] ^= 1; // 0이면 1로, 1이면 0으로
					}
				}
			} else { // 여자인 경우
				// 현재 수 변경
				switches[students[i][1]] ^= 1;
				// 좌우 조사
				int leftIdx = students[i][1]-1;
				int rightIdx = students[i][1]+1;
				while(leftIdx>=1 && rightIdx<=switchCnt) {
					if(switches[leftIdx] != switches[rightIdx]) { // 대칭이 아닌경우 ---> 탈출
						break;
					}
					
					switches[leftIdx--] ^= 1;
					switches[rightIdx++] ^= 1;
				}
			}
		}
		
		for(int i=1; i<=switchCnt; i++) {
			System.out.print(switches[i] + " ");
			if(i%20 == 0) {System.out.println();}
		}
	}

}
