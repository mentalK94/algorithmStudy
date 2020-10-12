/**
 * Backjoon - 1173. 운동
 * Health_1173.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Health_1173 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		if(m+T>M) {
			System.out.println(-1);
			return;
		}
		
		int healthTime = 0;
		int time = 0;
		int curM = m;
		while(true) {
			
			time++;
			if(curM+T <= M) {
				healthTime++;
				curM += T;
			} else {
				curM -= R;
				if(curM < m) {
					curM = m;
				}
			}
			
			if(healthTime == N) { break; }
		}
		
		System.out.println(time);
	}

}
