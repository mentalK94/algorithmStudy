/**
 * Backjoon - 1138. 한 줄로 서기
 * StandLine_1138.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StandLine_1138 {

	static int N;
	static int[] info, orders;
	static boolean[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		info = new int[N+1];
		orders = new int[N+1];
		selected = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		permutation(1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void permutation(int cnt) {
		if(cnt == N+1) {
			
			boolean isSuccess = true;
			
			for(int i=1; i<=N; i++) {
				int key = orders[i];
				int leftCnt = info[key]; // 자기 자신보다 큰 사람이 왼쪽에 몇명 있는지 확인
				
				int tempCnt = 0;
				for(int j=i-1; j>=0; j--) {
					if(orders[j]>key) { tempCnt++;}
				}

				if(leftCnt != tempCnt) { 
					isSuccess = false;
					break;
				}
				
			}
			
			if(isSuccess) {
				for(int i=1; i<=N; i++) {
					sb.append(orders[i]).append(" ");
				}
			}
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(selected[i]) { continue; }
			orders[cnt] = i;
			selected[i] = true;
			permutation(cnt+1);
			selected[i] = false;
		}
		
	}

}
