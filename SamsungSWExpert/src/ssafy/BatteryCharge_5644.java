/**
 * Samsung SW Expert - 5644. 무선 충전
 * BatteryCharge_5644.java
 * @date 2020-11-02
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Charge {
	int x;
	int y;
	int c; // 충전 범위
	int p; // 충전량
	
	public Charge(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}

public class BatteryCharge_5644 {
	
	static int answer, chargeCnt, dirCnt, aX, aY, bX, bY; // 충전기의 갯수, 이동횟수, a의 위치, b의 위치
	static int[] dx = {0, -1, 0, 1, 0}; // 상,우,하,좌
	static int[] dy = {0, 0, 1, 0, -1};
	static int[] dirA, dirB;
	static ArrayList<Charge> charges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {			

			StringTokenizer st = new StringTokenizer(br.readLine());
			dirCnt = Integer.parseInt(st.nextToken()); // 이동정보 갯수
			chargeCnt = Integer.parseInt(st.nextToken()); // 충전기 갯수
			
			dirA = new int[dirCnt+1];
			dirB = new int[dirCnt+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=dirCnt; i++) { dirA[i] = Integer.parseInt(st.nextToken()); }
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=dirCnt; i++) { dirB[i] = Integer.parseInt(st.nextToken()); }
			dirA[0] = 0; dirB[0] = 0;
			
			charges = new ArrayList<>();
			
			// 충전기 정보 입력
			for(int i=0; i<chargeCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				charges.add(new Charge(x, y, c, p));
			}
			
			answer = 0;
			aX=1; aY=1; bX=10; bY=10;
			
			move();
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void move() {
		
		for(int step=0; step<=dirCnt; step++) {
			
			// A와 B의 이동
			aX += dx[dirA[step]];
			aY += dy[dirA[step]];
			bX += dx[dirB[step]];
			bY += dy[dirB[step]];
			
			int tempMax = 0;
			int aCharge = 0;
			int bCharge = 0;
			
			// 충전 여부확인
			for(int i=0; i<chargeCnt; i++) {
				Charge charge = charges.get(i);
				int dist = getDist(aX, aY, charge.x, charge.y);
				if(dist <= charge.c) {
					aCharge = charge.p;
				} else {
					aCharge = 0;
				}
				for(int j=0; j<chargeCnt; j++) {
					int max = 0;
					Charge charge2 = charges.get(j);
					int dist2 = getDist(bX, bY, charge2.x, charge2.y);
					if(dist2 <= charge2.c) {
						bCharge = charge2.p;
					} else {
						bCharge = 0;
					}
					
					if(i==j && (aCharge!=0 && bCharge !=0)) { // 같은 충전기를 사용한 경우
						max = aCharge;
					} else { // 다른 충전기를 사용한 경우
						max += aCharge;
						max += bCharge;
					}
					
					if(tempMax < max) {
						tempMax = max;
					}
					
				}
			}
			answer += tempMax;
		}
	}

	private static int getDist(int x, int y, int tx, int ty) {
		return Math.abs(x-tx) + Math.abs(y-ty); 
	}

}
