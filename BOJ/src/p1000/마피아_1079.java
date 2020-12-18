/**
 * Backjoon - 1079. 마피아
 * 마피아_1079.java
 * @date 2020-12-18
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마피아_1079 {

	static int[] crimes; // 유죄지수
	static int[][] relation; // 관계
	static int mafia, N; // 마피아의 번호 
	static int answer;
	static boolean[] isDead; // 죽은 참가자 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 참가자 수
		
		crimes = new int[N];
		relation = new int[N][N];
		isDead = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			crimes[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				relation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		mafia = Integer.parseInt(br.readLine()); // 마피아의 번호
		
		answer = 0;
		game(0, N);		
		
		System.out.println(answer);
		br.close();
	}

	private static void game(int nightCnt, int user) {
		if(user == 1 || isDead[mafia]) {
			answer = answer < nightCnt ? nightCnt : answer;
			return;
		}
		
		if(user%2==0) { // 밤
			for(int i=0; i<N; i++) {
				if(i == mafia || isDead[i]) continue; // 마피아 자기자신인 경우나 이미 죽은 참가자인 경우 패스
				
				for(int j=0; j<N; j++) {
					crimes[j] += relation[i][j];
				}
				
				isDead[i] = true; // 죽음을 표기
				game(nightCnt+1, user-1);
				
				// 원상 복구
				for(int j=0; j<N; j++) {
					crimes[j] -= relation[i][j];
				}
				isDead[i] = false;
			}			
		} else { // 낮
			// 유죄번호가 가장 높은 참가자 죽음
			int killUserIdx = 0; // 다음 죽을 참가자 선정
			int crimeNum = 0;
			for(int i=0; i<N; i++) {
				if(isDead[i]) { continue; }
				if(crimeNum < crimes[i]) {
					killUserIdx = i;
					crimeNum = crimes[i];
				}
			}			
			
			isDead[killUserIdx] = true;
			game(nightCnt, user-1);
			isDead[killUserIdx] = false;
		}
	}
}