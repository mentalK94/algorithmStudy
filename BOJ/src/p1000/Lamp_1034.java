/**
 * Backjoon - 1034. 램프
 * Lamp_1034.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lamp_1034 {
	
	static int N, M, K;
	static int[][] map;
	static boolean[] isLampOn;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		isLampOn = new boolean[N];
		
		// 해당 행을 K번째 횟수로 켤 수 있는 지 확인
		checkLamp();
		
		int answer = 0;
		
		// K가 0이면
		if(K==0) {
			for(int i=0; i<N; i++) { 
				if(isLampOn[i]) { answer++;}
			}
		} else {
			
			for(int i=0; i<N; i++) {
				// 해당 행이 켜질 수 없다면  패스
				if(!isLampOn[i]) { continue;}
				// 기준 행 선정 -> i
				int cnt = 1;
				for(int j=0; j<N; j++) {
					if(i == j) {continue;}
					if(!isLampOn[j]) {continue;}
					boolean isEqual = true;
					for(int k=0; k<M; k++) {
						if(map[i][k] != map[j][k]) {
							isEqual = false;
							break;
						}
					}
					
					if(isEqual) { cnt++; }
				}
				
				if(answer < cnt) { answer = cnt; }
			}			
		}
		
		bw.write(""+answer);
		bw.flush();
		bw.close();
		br.close();
	}

	private static void checkLamp() {
		for(int i=0; i<N; i++) {
			int offCnt = 0;
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) { offCnt++; }
			}
			
			if(K==0 && offCnt == 0) { isLampOn[i] = true; }
			else {
				if(K>=offCnt && K%2 == 0 && offCnt%2 == 0) { isLampOn[i] = true; }
				if(K>=offCnt && K%2 == 1 && offCnt%2 == 1) { isLampOn[i] = true; }
			}
		}
	}
}
