/**
 * Backjoon - 1268. 임시 반장 정하기
 * TempClassPresident_1268.java
 * @date 2020-10-13
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TempClassPresident_1268 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] student = new int[n+1][6];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<6; j++) {
				int cls = Integer.parseInt(st.nextToken());
				student[i][j] = cls;
			}
		}
		
		int idx = 1;
		int value = 0;
		for(int i=1; i<=n; i++) {

			boolean[] stu = new boolean[n+1];
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				if(i == j) continue;
				if(stu[j]) continue;
				for(int k=1; k<6; k++) {
					if(student[i][k] == student[j][k]) {
						stu[j] = true;
						break;
					}
				}
			}
			
			for(int j=1; j<=n; j++) {
				if(stu[j]) cnt++;
			}
			
			if(cnt>value) {
				idx = i;
				value = cnt;
			}
		}
		
		System.out.println(idx);
		
	}

}
