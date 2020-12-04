/**
 * Samsung SW Expert - 8382. 방향 전환
 * ChangeDirection_8382.java
 * @date 2020-12-04
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChangeDirection_8382 {

	static int answer, targetX, targetY, dist;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());
			
			dist = getDist(x1, y1, targetX, targetY);
			
			answer = Integer.MAX_VALUE;
			
			go(x1, y1, 0, 0); // 0이면 가로
			go(x1, y1, 1, 0); // 1이면 세로
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int getDist(int x, int y, int tX, int tY) {
		return Math.abs(x-tX) + Math.abs(y-tY);
	}

	private static void go(int x, int y, int dir, int cnt) {
				
		if(answer <= cnt) { return; }
		
		// 목적지에 도착한 경우
		if(x == targetX && y == targetY) {
			answer = cnt < answer ? cnt : answer;
			return;
		}
		
		// 가로로 가야하는 경우
		if(dir == 0) {
			if(x<=targetX) {
				go(x+1, y, 1, cnt+1);				
			} else { 
				go(x-1, y, 1, cnt+1);
			}
		} else { // 세로로 가야하는 경우
			if(y<=targetY) {
				go(x, y+1, 0, cnt+1);
			} else {
				go(x, y-1, 0, cnt+1);
			}
		}
	}

}
