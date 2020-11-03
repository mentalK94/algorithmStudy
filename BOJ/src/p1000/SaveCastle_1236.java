/**
 * Backjoon - 1236. 성 지키기
 * SaveCastle_1236.java
 * @date 2020-10-26
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaveCastle_1236 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int r = 0;
		for(int i=0; i<N; i++) {
			boolean isSave = false;
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'X') {
					isSave = true;
					break;
				}
			}
			
			if(!isSave) {r++;}
		}
		
		int c = 0;
		for(int i=0; i<M; i++) {
			boolean isSave = false;
			for(int j=0; j<N; j++) {
				if(map[j][i] == 'X') {
					isSave = true;
					break;
				}
			}
			
			if(!isSave) {c++;}
		}
		
		int answer = r>c?r:c;
		System.out.println(answer);
	}
}