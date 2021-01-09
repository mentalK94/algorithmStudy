/**
 * Backjoon - 1074. Z
 * Z_1074.java
 * @date 2021-01-07
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String dest = br.readLine();
		int len = dest.length();
		int N = Integer.parseInt(dest);
		int M = Integer.parseInt(br.readLine());
		
		boolean[] broken = new boolean[10];
		
		if(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int cur = 100;
		int answer = Math.abs(cur-N);
		
		if(Math.abs(cur-N)>len) { // 채널번호를 누르는 행위보다 +-버튼누르는게 더 먼 경우
			
			int upCnt = 0;
			int downCnt = 0;
			int up = N;
			int down = N;
			
			// 아랫버튼 누르는 경우
			while(true) {
				String downChannel = String.valueOf(down);
				boolean possible = true;
				for(int i=0; i<downChannel.length(); i++) {
					if(broken[downChannel.charAt(i)-'0']) { // 고장난 버튼이 있는 경우
						possible = false;
						break;
					}
				}
				
				if(possible) { // 가능한 경우
					answer = downCnt+downChannel.length();
					break;
				}
				
				down--;
				downCnt++;
				if(down < 0 || answer <= downCnt+downChannel.length()) { break; }
			}
			
			while(true) {
				String upChannel = String.valueOf(up);
				boolean possible = true;
				for(int i=0; i<upChannel.length(); i++) {
					if(broken[upChannel.charAt(i)-'0']) { // 고장난 버튼이 있는 경우
						possible = false;
						break;
					}
				}
				
				if(possible) { // 가능한 경우
					answer = upCnt + upChannel.length();
					break;
				}

				up++;
				upCnt++;
				
				if(answer <= upCnt+upChannel.length()) { 
					break; 
				}
				
			}
		} 
		
		System.out.println(answer);
		br.close();
	}
}