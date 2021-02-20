/**
 * Backjoon - 1453. 피시방 알바
 * 피시방알바_1453.java
 * @date 2021-02-20
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피시방알바_1453 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] checked = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(checked[num]) { answer++; }
			else { checked[num] = true; }
		}
		
		System.out.println(answer);
		br.close();
	}
}