/**
 * Backjoon - 13300. 방 배정
 * RoomAssignment_13300.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomAssignment_13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] students = new int[2][7];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 입력
		int K = Integer.parseInt(st.nextToken()); // 한 방에 최대 인원 수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 학생 성별
			int y = Integer.parseInt(st.nextToken()); // 학생 학년
			students[s][y]++;
		}
		
		int room = 0;
		
		for(int i=0; i<2; i++) {
			for(int j=1; j<=6; j++) {
				room += (students[i][j]/K);
				if(students[i][j]%K != 0) {
					room++;
				}
			}
		}
		
		System.out.println(room);
		
	}

}
