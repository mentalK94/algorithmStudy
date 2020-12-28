/**
 * Backjoon - 2346. 풍선 터뜨리기
 * 풍선터뜨리기_2346.java
 * @date 2020-12-28
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 풍선터뜨리기_2346 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] ballon = new int[N];
		
		for(int i=0; i<N; i++) {
			ballon[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		int next = 0;
		int count = 0;
		
		while(true) {
			
			// 1. 풍선 터뜨리기 
			next = ballon[idx];			
			sb.append(idx+1).append(" ");
			ballon[idx] = 0;
			
			if(++count == N) { break;}
			
			// 2. 터뜨린 풍선에 적혀있는 번호를 토대로 다음 idx찾기
			int dir = next>0 ? 1 : -1;
			
			next = Math.abs(next);
			for(int j=0; j<next; j++) {
				idx = dir>0 ? ++idx : --idx;
				idx = idx==N ? 0 : idx;
				idx = idx==-1 ? N-1 : idx;
				
				if(ballon[idx] == 0) {
					j--;
				}
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}